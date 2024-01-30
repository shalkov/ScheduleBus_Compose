package ru.shalkoff.repository

import ru.shalkoff.model.Cat
import ru.shalkoff.model.Schedules

interface IScheduleRepository {

    suspend fun getCats(count: Int): List<Cat>

    suspend fun getAllSchedule(): Schedules
}
