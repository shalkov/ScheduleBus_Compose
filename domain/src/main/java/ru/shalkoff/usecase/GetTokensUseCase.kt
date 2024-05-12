package ru.shalkoff.usecase

import ru.shalkoff.model.Tokens
import ru.shalkoff.repository.IAuthRepository
import javax.inject.Inject

class GetTokensUseCase @Inject constructor(
    private val authRepository: IAuthRepository
) {

    suspend operator fun invoke(): Tokens? {
        return authRepository.getTokens()
    }
}