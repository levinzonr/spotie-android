package cz.levinzonr.spotie.domain.usecases

import cz.levinzonr.spotie.domain.repositories.TokenRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val tokenRepository: TokenRepository
) {
    suspend fun login(token: String?) : UseCaseResult<Unit> = safeUseCaseCall {
        val userToken = requireNotNull(token)
        tokenRepository.set(userToken)
    }
}