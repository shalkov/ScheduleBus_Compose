package ru.shalkoff.model

import kotlinx.serialization.Serializable
import ru.shalkoff.Transformable

@Serializable
data class ScheduleResponse(
    val route: ScheduleRouteObj? = null
): Transformable<Schedule> {

    override fun transform(): Schedule {
        return Schedule(
            route = route?.transform()
        )
    }
}