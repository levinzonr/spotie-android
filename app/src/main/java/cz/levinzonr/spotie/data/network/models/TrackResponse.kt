package cz.levinzonr.spotie.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class TrackResponse(
    val album: AlbumData,
    val artists: List<ArtistData>,
    val available_markets: List<String>,
    val disc_number: Int,
    val duration_ms: Long,
    val explicit: Boolean,
    val external_ids: Map<String, String>,
    val external_urls: Map<String, String>,
    val href: String,
    val id: String,
    val is_local: Boolean,
    val name: String,
    val popularity: Int,
    val preview_url: String? = null,
    val track_number: Int,
    val type: String,
    val uri: String
)
