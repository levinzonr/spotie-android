package cz.levinzonr.spotie.domain.usecases

import cz.levinzonr.spotie.domain.repositories.AuthRepository
import cz.levinzonr.spotie.domain.repositories.TokenRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val tokenRepository: TokenRepository
) {
    suspend fun login(token: String?) : UseCaseResult<Unit> = safeUseCaseCall {
        val userToken = requireNotNull(token)
        val token = authRepository.loginWithAuthCode(userToken)
        tokenRepository.refreshToken = token.refreshToken
        tokenRepository.token = token.accessToken
    }
}