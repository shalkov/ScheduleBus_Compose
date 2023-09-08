package ru.shalkoff.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ScheduleRepository @Inject constructor() : IScheduleRepository {

    private val allItems: MutableStateFlow<List<ScheduleResponse>> = MutableStateFlow(
        listOf(
            ScheduleResponse(
                id = 1,
                title = "Item 1",
                description = "Description",
                timestamp = 1672368617954,
                isBookmarked = false
            ),
            ScheduleResponse(
                id = 2,
                title = "Item 2",
                description = "Description",
                timestamp = 1664678230741,
                isBookmarked = false
            ),
            ScheduleResponse(
                id = 3,
                title = "Item 3",
                description = "Description",
                timestamp = 1667884312189,
                isBookmarked = false
            )
        )
    )

    override val observeAllModels: Flow<List<ScheduleResponse>> = allItems

    override fun observeModelById(id: Long): Flow<ScheduleResponse> = observeAllModels.map { items ->
        items.firstOrNull { model -> model.id == id }
            ?: throw NoSuchElementException("$id not found")
    }

    override suspend fun bookmark(id: Long, isBookmarked: Boolean) {
        allItems.getAndUpdate { items ->
            items.map { model ->
                if(model.id == id) {
                    model.copy(isBookmarked = isBookmarked)
                } else {
                    model
                }
            }
        }
    }
}
