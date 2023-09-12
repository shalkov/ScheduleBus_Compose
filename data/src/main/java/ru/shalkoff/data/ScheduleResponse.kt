package ru.shalkoff.data

data class ScheduleResponse(
    val id: Long,
    val title: String,
    val description: String,
    val timestamp: Long,
    val isBookmarked: Boolean
)
