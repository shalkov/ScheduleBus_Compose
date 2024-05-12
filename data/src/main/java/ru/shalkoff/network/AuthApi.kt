package ru.shalkoff.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import ru.shalkoff.Urls
import ru.shalkoff.di.Schedule
import ru.shalkoff.model.auth.AuthRequest
import ru.shalkoff.model.auth.AuthResponse
import javax.inject.Inject

class AuthApi @Inject constructor(
    @Schedule private val httpScheduleClient: HttpClient
) {

    suspend fun auth(
        login: String,
        password: String
    ): AuthResponse {
        return httpScheduleClient.post(Urls.ALL_SCHEDULE) {
            contentType(ContentType.Application.Json)
            setBody(AuthRequest(login, password))
        }.body()
    }
}