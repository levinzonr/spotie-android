package cz.levinzonr.spotie.data.repository

import android.util.Base64
import cz.levinzonr.spotie.data.mappers.AuthResponseMapper
import cz.levinzonr.spotie.data.network.AuthApi
import cz.levinzonr.spotie.domain.models.SpotifyCredentials
import cz.levinzonr.spotie.domain.models.Token
import cz.levinzonr.spotie.domain.repositories.AuthRepository
import java.util.*
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val credentials: SpotifyCredentials,
) : AuthRepository {

    override suspend fun loginWithAuthCode(code: String): Token {
        val response = authApi.obtainAccessTokenAsync(
            code = code,
            clientId = credentials.clientId,
            clientSecret = credentials.clientSecret
        )
        return AuthResponseMapper.toDomain(response)
    }

    override suspend fun refreshToken(token: String): Token {
        val secret = "${credentials.clientId}:${credentials.clientSecret}".toByteArray()
        val encoded = Base64.encode(secret, Base64.NO_WRAP)
        val response = authApi.refreshAccessToken(token, "Basic ${String(encoded)}")
        return AuthResponseMapper.toDomain(response)
    }
}