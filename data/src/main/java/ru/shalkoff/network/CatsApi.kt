package ru.shalkoff.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import ru.shalkoff.model.CatResponse
import javax.inject.Inject

class CatsApi @Inject constructor(
    private val httpClient: HttpClient
) {

    suspend fun getCats(count: Int): List<CatResponse> {
        return httpClient.get(
            "/v1/images/search?limit=$count"
        ).body()
    }
}