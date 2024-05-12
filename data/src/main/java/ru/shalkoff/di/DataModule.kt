package ru.shalkoff.di

import ru.shalkoff.repository.IScheduleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.shalkoff.repository.AuthRepository
import ru.shalkoff.repository.IAuthRepository
import ru.shalkoff.repository.ScheduleRepository
import ru.shalkoff.storage.ITokenStorage
import ru.shalkoff.storage.TokenStorage
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ScheduleModule {

    @Binds
    abstract fun bindScheduleRepository(
        repository: ScheduleRepository
    ): IScheduleRepository

    @Binds
    abstract fun bindAuthRepository(
        repository: AuthRepository
    ): IAuthRepository

    @Binds
    @Singleton
    abstract fun bindTokenStorage(
        tokenStorage: TokenStorage
    ): ITokenStorage
}
