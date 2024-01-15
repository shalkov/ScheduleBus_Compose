package ru.shalkoff.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatResponse(
    @SerialName("id")
    val id: String,
    @SerialName("url")
    val url: String
)