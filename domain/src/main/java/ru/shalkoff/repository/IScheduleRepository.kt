package ru.shalkoff.repository

import ru.shalkoff.model.Cat

interface IScheduleRepository {

    suspend fun getCats(count: Int): List<Cat>
}
