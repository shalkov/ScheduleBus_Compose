package ru.shalkoff.model.auth

import kotlinx.serialization.Serializable
import ru.shalkoff.Transformable
import ru.shalkoff.model.Tokens

@Serializable
data class TokensResponse(
    val accessToken: String,
    val refreshToken: String
): Transformable<Tokens> {

    override fun transform(): Tokens {
        return Tokens(
            accessToken,
            refreshToken
        )
    }
}