package cz.levinzonr.spotie.data.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlaylistResponse(
    @SerialName("collaborative")
    val collaborative: Boolean,
    @SerialName("external_urls")
    val externalUrls: Map<String, String>,
    @SerialName("href")
    val href: String,
    @SerialName("id")
    val id: String,
    @SerialName("images")
    val images: List<ImageData>,
    @SerialName("name")
    val name: String,
    @SerialName("owner")
    val owner: OwnerData,
    @SerialName("snapshot_id")
    val snapshotId: String,
    @SerialName("tracks")
    val tracks: PlaylistTracksData,
    @SerialName("type")
    val type: String,
    @SerialName("uri")
    val uri: String
)