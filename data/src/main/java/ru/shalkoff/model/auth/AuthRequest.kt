package ru.shalkoff.model.auth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthRequest(
    @SerialName("login")
    val login: String,
    @SerialName("password")
    val password: String
)