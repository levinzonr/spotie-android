package cz.levinzonr.spotie.domain.models

data class TopTracks(
    val shortTerm: List<Track> = List(3) { Track() },
    val midTerm: List<Track> = List(3) { Track() },
    val longTerm: List<Track> = List(3) { Track() },
)
