package ru.shalkoff.usecase

import ru.shalkoff.repository.IScheduleRepository
import javax.inject.Inject

class GetCatsUseCase @Inject constructor(
    private val scheduleRepository: IScheduleRepository
) {
    suspend operator fun invoke(
        count: Int
    ) = scheduleRepository.getCats(count)
}