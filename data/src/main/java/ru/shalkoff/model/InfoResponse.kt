package ru.shalkoff.model

import kotlinx.serialization.Serializable
import ru.shalkoff.Transformable

@Serializable
data class InfoResponse(
    val status: String,
    val message: String
): Transformable<Info> {

    override fun transform(): Info {
        return Info(
            status,
            message
        )
    }
}