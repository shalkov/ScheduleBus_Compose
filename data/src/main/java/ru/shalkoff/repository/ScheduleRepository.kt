package ru.shalkoff.repository

import ru.shalkoff.model.Cat
import ru.shalkoff.model.Schedule
import ru.shalkoff.model.Schedules
import ru.shalkoff.network.CatsApi
import ru.shalkoff.network.SchedulesApi
import ru.shalkoff.transformList
import javax.inject.Inject

class ScheduleRepository @Inject constructor(
    private val catsApi: CatsApi,
    private val scheduleApi: SchedulesApi
) : IScheduleRepository {

    override suspend fun getCats(count: Int): List<Cat> {
        return catsApi.getCats(count).transformList()
    }

    override suspend fun getAllSchedule(): Schedules {
       return scheduleApi.getAll().transform()
    }

    override suspend fun getRouteByNumber(
        routeNumber: String
    ): Schedule {
        return scheduleApi.getByNumber(routeNumber).transform()
    }
}
