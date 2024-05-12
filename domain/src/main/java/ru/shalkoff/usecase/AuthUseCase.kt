package ru.shalkoff.usecase

import ru.shalkoff.repository.IAuthRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val authRepository: IAuthRepository
) {

    suspend operator fun invoke(
        login: String,
        password: String
    ) = authRepository.auth(login, password)
}