package cz.levinzonr.spotie.domain.models

data class Album(
    val id: String = "id",
    val title: String = "Moving Forward",
    val type: String = "single",
    val tracksCount: Int = 1,
    val releaseDate: String = "",
    val image: String? = "https://i.scdn.co/image/ab67616d0000b273583e9558baac47836db06acf",
) {
    val uri: String get() = "spotify:album:$id"
}