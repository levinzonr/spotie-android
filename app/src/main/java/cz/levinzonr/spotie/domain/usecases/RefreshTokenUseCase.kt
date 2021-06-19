package cz.levinzonr.spotie.domain.usecases

import cz.levinzonr.spotie.domain.repositories.AuthRepository
import cz.levinzonr.spotie.domain.repositories.TokenRepository
import javax.inject.Inject

class RefreshTokenUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val tokenRepository: TokenRepository
) {
    suspend fun refresh() = safeUseCaseCall {
        val refreshToken = requireNotNull(tokenRepository.refreshToken)
        val refreshed = authRepository.refreshToken(refreshToken)
        tokenRepository.token = refreshed.accessToken
        refreshed.refreshToken?.let { tokenRepository.refreshToken = it}
        refreshed
    }
}