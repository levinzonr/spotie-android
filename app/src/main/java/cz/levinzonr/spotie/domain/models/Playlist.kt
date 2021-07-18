package cz.levinzonr.spotie.domain.models

data class Playlist(
    val id: String = "id",
    val name: String = "Playlist name",
    val isCollaborative: Boolean = false
)