package cz.levinzonr.spotie.domain.models

data class NewRelease(
    val artistName: String = "Tough Decisions Ahead",
    val album: Album = Album()
) {
    val track = Track(title = album.title, artistName = artistName, imageUrl = album.image)
}