package ru.shalkoff.storage

import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import android.util.Base64
import ru.shalkoff.model.Tokens

object KeyStoreTokenHelper {

    private const val ANDROID_KEYSTORE = "AndroidKeyStore"

    private const val AES_MODE = "AES/GCM/NoPadding"
    private const val AES_KEY_SIZE = 256

    private const val SHARED_PREFS_NAME = "TokenPrefs"
    private const val ENCRYPTED_TOKEN_KEY = "EncryptedTokens"
    private const val SECRET_KEY_ALIAS = "TokenSecretKey"

    fun saveTokens(context: Context, tokens: Tokens) {
        val keyStore = KeyStore.getInstance(ANDROID_KEYSTORE)
        keyStore.load(null)

        var secretKey = keyStore.getKey(SECRET_KEY_ALIAS, null) as? SecretKey

        if (secretKey == null) {
            secretKey = generateSecretKey()
            keyStore.setKeyEntry(SECRET_KEY_ALIAS, secretKey, null, null)
        }

        val cipher = Cipher.getInstance(AES_MODE)
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)

        val tokensString = "${tokens.accessToken}:${tokens.refreshToken}"
        val encryptedBytes = cipher.doFinal(tokensString.toByteArray(Charsets.UTF_8))

        val encryptedTokens = Base64.encodeToString(encryptedBytes, Base64.DEFAULT)

        // Сохраняем зашифрованные токены в SharedPreferences
        val sharedPrefs = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        sharedPrefs.edit().putString(ENCRYPTED_TOKEN_KEY, encryptedTokens).apply()
    }

    fun getTokens(context: Context): Tokens? {
        val keyStore = KeyStore.getInstance(ANDROID_KEYSTORE)
        keyStore.load(null)

        val secretKey = keyStore.getKey(SECRET_KEY_ALIAS, null) as? SecretKey

        val sharedPrefs = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        val encryptedTokens = sharedPrefs.getString(ENCRYPTED_TOKEN_KEY, null)

        if (secretKey != null && encryptedTokens != null) {
            val cipher = Cipher.getInstance(AES_MODE)
            cipher.init(Cipher.DECRYPT_MODE, secretKey)

            val encryptedBytes = Base64.decode(encryptedTokens, Base64.DEFAULT)
            val decryptedBytes = cipher.doFinal(encryptedBytes)

            val tokensString = String(decryptedBytes, Charsets.UTF_8)
            val tokens = tokensString.split(":")
            return Tokens(tokens[0], tokens[1])
        }

        return null
    }

    fun clearTokens(context: Context) {
        val sharedPrefs = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        sharedPrefs.edit().remove(ENCRYPTED_TOKEN_KEY).apply()

        val keyStore = KeyStore.getInstance(ANDROID_KEYSTORE)
        keyStore.load(null)
        keyStore.deleteEntry(SECRET_KEY_ALIAS)
    }

    private fun generateSecretKey(): SecretKey {
        val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, ANDROID_KEYSTORE)
        val keyGenParameterSpec = KeyGenParameterSpec.Builder(SECRET_KEY_ALIAS, KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .setRandomizedEncryptionRequired(false)
            .setKeySize(AES_KEY_SIZE)
            .build()

        keyGenerator.init(keyGenParameterSpec)
        return keyGenerator.generateKey()
    }
}