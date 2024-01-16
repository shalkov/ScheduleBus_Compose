package ru.shalkoff.di

import ru.shalkoff.repository.IScheduleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.shalkoff.repository.ScheduleRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class ScheduleModule {

    @Binds
    abstract fun bindScheduleRepository(repository: ScheduleRepository): IScheduleRepository
}
