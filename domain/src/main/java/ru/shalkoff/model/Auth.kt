package ru.shalkoff.model

data class AuthModel(
    val id: Int,
    val login: String,
    val fullName: String,
    val role: String,
    val tokens: Tokens,
    val info: Info
)

data class Tokens(
    val accessToken: String,
    val refreshToken: String
)