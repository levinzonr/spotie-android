package cz.levinzonr.spotie.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class FollowersData(
    val href: String?,
    val total: Int
)
