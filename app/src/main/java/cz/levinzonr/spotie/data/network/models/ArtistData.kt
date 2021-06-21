package cz.levinzonr.spotie.data.network.models

data class ArtistData(
    val external_urls: Map<String, String>,
    val href: String,
    val id: String,
    val name: String,
    val type: String,
    val uri: String
)