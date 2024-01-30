package ru.shalkoff.model

import kotlinx.serialization.Serializable
import ru.shalkoff.Consts.EMPTY_INT
import ru.shalkoff.Consts.EMPTY_STRING
import ru.shalkoff.Transformable
import ru.shalkoff.transformNullList

@Serializable
data class SchedulesResponse(
    val routes: List<ScheduleRouteObj>? = null
) : Transformable<Schedules> {

    override fun transform(): Schedules {
        return Schedules(
            routes = routes.transformNullList()
        )
    }
}

@Serializable
data class ScheduleRouteObj(
    val id: Int? = null,
    val routeNumber: String? = null,
    val name: String? = null,
    val description: String? = null,
    val departureStart: DepartureInfoObj? = null,
    val departureEnd: DepartureInfoObj? = null
) : Transformable<ScheduleRoute> {

    override fun transform(): ScheduleRoute {
        return ScheduleRoute(
            id = id ?: EMPTY_INT,
            routeNumber = routeNumber ?: EMPTY_STRING,
            name = name ?: EMPTY_STRING,
            description = description ?: EMPTY_STRING,
            departureStart = departureStart?.transform() ?: DepartureInfoObj.EMPTY.transform(),
            departureEnd = departureEnd?.transform() ?: DepartureInfoObj.EMPTY.transform()
        )
    }
}

/**
 * @param departureFrom - отправление из.
 * @param timeList - список объектов с информацией о времени отправления.
 */
@Serializable
data class DepartureInfoObj(
    val id: Int? = null,
    val departureFrom: String? = null,
    val timeList: List<ScheduleTimeObj>? = null
) : Transformable<DepartureInfo> {

    override fun transform(): DepartureInfo {
        return DepartureInfo(
            id = id ?: EMPTY_INT,
            departureFrom = departureFrom ?: EMPTY_STRING,
            timeList = timeList.transformNullList()
        )
    }

    companion object {

        val EMPTY = DepartureInfoObj(
            id = EMPTY_INT,
            departureFrom = EMPTY_STRING,
            timeList = listOf()
        )
    }

}

@Serializable
data class ScheduleTimeObj(
    val id: Int? = null,
    val time: String? = null,
    val description: String? = null
) : Transformable<ScheduleTime> {

    override fun transform(): ScheduleTime {
        return ScheduleTime(
            id = id ?: EMPTY_INT,
            time = time ?: EMPTY_STRING,
            description = description ?: EMPTY_STRING
        )
    }
}