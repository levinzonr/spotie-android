package cz.levinzonr.spotie.domain.repositories

import cz.levinzonr.spotie.domain.models.Token

interface AuthRepository {
    suspend fun loginWithAuthCode(code: String): Token
    suspend fun refreshToken(token: String): Token
}
