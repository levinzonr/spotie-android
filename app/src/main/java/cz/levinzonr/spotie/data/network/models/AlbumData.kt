package cz.levinzonr.spotie.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class AlbumData(
    val album_type: String,
    val artists: List<ArtistData>,
    val external_urls: Map<String, String>,
    val href: String,
    val id: String,
    val images: List<ImageData>,
    val name: String,
    val release_date: String,
    val release_date_precision: String,
    val total_tracks: Int,
    val type: String,
    val uri: String
)