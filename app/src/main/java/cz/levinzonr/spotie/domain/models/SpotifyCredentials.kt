package cz.levinzonr.spotie.domain.models

data class SpotifyCredentials(
    val clientId: String,
    val redirectUri: String,
    val clientSecret: String
)
