package cz.levinzonr.spotie.data.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlaylistTracksData(
    @SerialName("href")
    val href: String,
    @SerialName("total")
    val total: Int
)