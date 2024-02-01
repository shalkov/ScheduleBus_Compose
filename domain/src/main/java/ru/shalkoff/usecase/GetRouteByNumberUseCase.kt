package ru.shalkoff.usecase

import ru.shalkoff.model.Schedule
import ru.shalkoff.repository.IScheduleRepository
import javax.inject.Inject

class GetRouteByNumberUseCase @Inject constructor(
    private val scheduleRepository: IScheduleRepository
) {

    suspend operator fun invoke(routeNumber: String): Schedule {
        return scheduleRepository.getRouteByNumber(routeNumber)
    }
}