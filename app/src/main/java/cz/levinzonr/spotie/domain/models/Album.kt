package cz.levinzonr.spotie.domain.models

data class Album(
    val id: String = "id",
    val title: String = "Moving Forward",
    val type: String = "single",
    val tracksCount: Int = 1,
    val releaseDate: String = "",
    val image: String? = null,

)