package cz.levinzonr.spotie.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class PaginatedResponse(
        val href: String,
        val items: List<TrackResponse>,
        val limit: Int,
        val next: String?,
        val offset: Int,
        val previous: String? = null,
        val total: Int
)