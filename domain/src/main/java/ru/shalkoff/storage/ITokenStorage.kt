package ru.shalkoff.storage

import ru.shalkoff.model.Tokens

interface ITokenStorage {

    fun saveTokens(tokens: Tokens)

    fun getTokens(): Tokens?

    fun clearTokens()
}