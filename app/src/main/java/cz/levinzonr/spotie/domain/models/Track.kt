package cz.levinzonr.spotie.domain.models

data class Track(
    val id: String = "id",
    val title: String = "Track Title",
    val imageUrl: String? = "https://i.scdn.co/image/ab67616d0000b273583e9558baac47836db06acf",
    val artistName: String = "Artist name"
)
