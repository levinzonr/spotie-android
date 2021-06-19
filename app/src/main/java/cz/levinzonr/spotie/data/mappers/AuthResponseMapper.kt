package cz.levinzonr.spotie.data.mappers

import cz.levinzonr.spotie.data.network.models.AuthResponse
import cz.levinzonr.spotie.domain.models.DtoMapper
import cz.levinzonr.spotie.domain.models.Token

object AuthResponseMapper: DtoMapper<AuthResponse, Token> {
    override fun toDomain(dto: AuthResponse): Token {
        return Token(
            accessToken = dto.access_token,
            refreshToken = dto.refresh_token
        )
    }
}