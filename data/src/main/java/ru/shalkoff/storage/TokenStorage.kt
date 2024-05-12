package ru.shalkoff.storage

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.shalkoff.model.Tokens
import javax.inject.Inject

class TokenStorage @Inject constructor(
    @ApplicationContext private val context: Context
) : ITokenStorage {

    override fun saveTokens(tokens: Tokens) {
        KeyStoreTokenHelper.saveTokens(context, tokens)
    }

    override fun getTokens(): Tokens? {
        return KeyStoreTokenHelper.getTokens(context)
    }

    override fun clearTokens() {
        KeyStoreTokenHelper.clearTokens(context)
    }
}