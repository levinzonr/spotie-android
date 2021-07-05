package cz.levinzonr.spotie.domain.models

data class TrackFeatures(
    val rhythm: Double,
    val energy: Double,
    val danceability: Double,
    val durationMs: Int,
)