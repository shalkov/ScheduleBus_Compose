package ru.shalkoff.storage

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.shalkoff.model.Tokens
import javax.inject.Inject

class TokenStorage @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val sharedPreferences = context.getSharedPreferences(
        PREF_NAME,
        Context.MODE_PRIVATE
    )

    fun saveTokens(tokens: Tokens) {
        val editor = sharedPreferences.edit()
        editor.putString(ACCESS_TOKEN_KEY, tokens.accessToken)
        editor.putString(REFRESH_TOKEN_KEY, tokens.refreshToken)
        editor.apply()
    }

    fun getTokens(): Tokens? {
        val accessToken = sharedPreferences.getString(ACCESS_TOKEN_KEY, null)
        val refreshToken = sharedPreferences.getString(REFRESH_TOKEN_KEY, null)
        return if (accessToken != null && refreshToken != null) {
            Tokens(accessToken, refreshToken)
        } else {
            null
        }
    }

    fun clearTokens() {
        val editor = sharedPreferences.edit()
        editor.remove(ACCESS_TOKEN_KEY)
        editor.remove(REFRESH_TOKEN_KEY)
        editor.apply()
    }

    companion object {

        private const val PREF_NAME = "TokenPrefs"
        private const val ACCESS_TOKEN_KEY = "accessToken"
        private const val REFRESH_TOKEN_KEY = "refreshToken"
    }
}