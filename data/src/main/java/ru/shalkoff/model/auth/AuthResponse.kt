package ru.shalkoff.model.auth

import kotlinx.serialization.Serializable
import ru.shalkoff.Transformable
import ru.shalkoff.model.AuthModel
import ru.shalkoff.model.InfoResponse

@Serializable
data class AuthResponse(
    val id: Int,
    val login: String,
    val fullName: String,
    val role: String, //todo добавить в будущем ENUM
    val tokens: TokensResponse,
    val info: InfoResponse
): Transformable<AuthModel> {

    override fun transform(): AuthModel {
        return AuthModel(
            id,
            login,
            fullName,
            role,
            tokens.transform(),
            info.transform()
        )
    }
}