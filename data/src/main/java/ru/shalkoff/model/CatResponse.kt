package ru.shalkoff.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.shalkoff.model.Cat
import ru.shalkoff.Transformable

@Serializable
data class CatResponse(
    @SerialName("id")
    val id: String,
    @SerialName("url")
    val url: String
) : Transformable<Cat> {

    override fun transform(): Cat {
        return Cat(
            id = id,
            url = url
        )
    }
}
