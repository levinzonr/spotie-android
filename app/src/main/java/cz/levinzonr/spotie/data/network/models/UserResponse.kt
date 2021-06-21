package cz.levinzonr.spotie.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val country: String? = null,
    val display_name: String,
    val email: String? = null,
    val external_urls: Map<String, String>,
    val followers: FollowersData,
    val href: String,
    val id: String,
    val images: List<ImageData>,
    val product: String? = null,
    val type: String,
    val uri: String
)
