package cz.levinzonr.spotie.domain.manager

import cz.levinzonr.spotie.domain.repositories.TokenRepository
import javax.inject.Inject

class UserManager @Inject constructor(
    private val tokenRepository: TokenRepository
) {
    fun isLoggedIn() : Boolean = tokenRepository.get() != null
}