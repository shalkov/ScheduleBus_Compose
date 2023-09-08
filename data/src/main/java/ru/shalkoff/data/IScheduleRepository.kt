package ru.shalkoff.data

import kotlinx.coroutines.flow.Flow

interface IScheduleRepository {
    val observeAllModels: Flow<List<ScheduleResponse>>

    fun observeModelById(id: Long): Flow<ScheduleResponse>

    suspend fun bookmark(id: Long, isBookmarked: Boolean)
}
