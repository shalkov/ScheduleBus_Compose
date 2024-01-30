package ru.shalkoff.model

data class Schedules(
    val routes: List<ScheduleRoute>
)

data class ScheduleRoute(
    val id: Int, // 0
    val routeNumber: String, // 310
    val name: String, // Графский (310)
    val description: String, // Автобус, едет по маршруту Графское - Воронеж, через Бабяково.
    val departureStart: DepartureInfo, // информация о времени маршрутов с начальной точки
    val departureEnd: DepartureInfo // информация о времени маршрутов с конечной точки
)

/**
 * @param departureFrom - отправление из.
 * @param timeList - список объектов с информацией о времени отправления.
 */
data class DepartureInfo(
    val id: Int,
    val departureFrom: String, // Воронеж
    val timeList: List<ScheduleTime>
)

data class ScheduleTime(
    val id: Int,
    val time: String, // 6:50
    val description: String // отправление из Парижской Коммуны
)
