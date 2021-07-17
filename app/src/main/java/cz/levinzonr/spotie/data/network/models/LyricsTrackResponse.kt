package cz.levinzonr.spotie.data.network.models

data class LyricsTrackResponse(
    val length: String,
    val result: List<LyricTrackResult>,
    val success: String
)