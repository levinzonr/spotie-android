package cz.levinzonr.spotie.domain.models

data class Track(
    val id: String,
    val title: String,
    val imageUrl: String?,
    val artistName: String
)
