package cz.levinzonr.spotie.domain.models

data class TrackFeatures(
    val rhythm: Double = 0.3,
    val energy: Double = 0.4,
    val danceability: Double = 0.5,
    val durationMs: Int = 1000,
)