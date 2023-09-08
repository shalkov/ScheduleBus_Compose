package ru.shalkoff.di

import ru.shalkoff.data.IScheduleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.shalkoff.data.ScheduleRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class ScheduleModule {

    @Binds
    abstract fun bindScheduleRepository(repository: ScheduleRepository): IScheduleRepository
}
