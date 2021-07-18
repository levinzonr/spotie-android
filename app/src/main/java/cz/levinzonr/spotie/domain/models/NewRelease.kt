package cz.levinzonr.spotie.domain.models

data class NewRelease(
    val artistName: String = "Tough Decisions Ahead",
    val album: Album = Album()
)