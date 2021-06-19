package cz.levinzonr.spotie.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class ImageData(
    val height: Int?,
    val url: String,
    val width: Int?
)