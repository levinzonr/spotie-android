package cz.levinzonr.spotie.domain.models

data class TopTracks(
    val shortTerm: List<Track>,
    val midTerm: List<Track>,
    val longTerm: List<Track>
)