package ru.shalkoff.repository

import ru.shalkoff.model.AuthModel
import ru.shalkoff.model.Tokens

interface IAuthRepository {

    suspend fun auth(
        login: String,
        password: String
    ): AuthModel

    suspend fun getTokens(): Tokens?
}