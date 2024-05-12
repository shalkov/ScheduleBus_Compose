package ru.shalkoff.repository

import ru.shalkoff.model.AuthModel
import ru.shalkoff.model.Tokens
import ru.shalkoff.network.AuthApi
import ru.shalkoff.storage.TokenStorage
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authApi: AuthApi,
    private val tokenStorage: TokenStorage
): IAuthRepository {

    override suspend fun auth(login: String, password: String): AuthModel {
        val auth = authApi.auth(login, password).transform()
        tokenStorage.saveTokens(auth.tokens)
        return auth
    }

    override suspend fun getTokens(): Tokens? {
        return tokenStorage.getTokens()
    }
}