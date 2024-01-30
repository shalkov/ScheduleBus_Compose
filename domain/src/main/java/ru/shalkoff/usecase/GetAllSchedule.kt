package ru.shalkoff.usecase

import ru.shalkoff.repository.IScheduleRepository
import javax.inject.Inject

class GetAllSchedule @Inject constructor(
    private val scheduleRepository: IScheduleRepository
) {
    suspend operator fun invoke() = scheduleRepository.getAllSchedule()
}