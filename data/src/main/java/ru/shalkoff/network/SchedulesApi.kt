package ru.shalkoff.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import ru.shalkoff.Urls.ALL_SCHEDULE
import ru.shalkoff.di.Schedule
import ru.shalkoff.model.SchedulesResponse
import javax.inject.Inject

class SchedulesApi @Inject constructor(
    @Schedule private val httpScheduleClient: HttpClient
) {

    suspend fun getAll(): SchedulesResponse {
        return httpScheduleClient.get(ALL_SCHEDULE).body()
    }
}