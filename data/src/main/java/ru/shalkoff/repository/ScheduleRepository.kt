package ru.shalkoff.repository

import ru.shalkoff.model.Cat
import ru.shalkoff.network.CatsApi
import ru.shalkoff.transformList
import javax.inject.Inject

class ScheduleRepository @Inject constructor(
    private val catsApi: CatsApi
) : IScheduleRepository {

    override suspend fun getCats(count: Int): List<Cat> {
        return catsApi.getCats(count).transformList()
    }

}
