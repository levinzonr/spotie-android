package cz.levinzonr.spotie.domain.models

data class Token(
    val accessToken: String,
    val refreshToken: String?
)
