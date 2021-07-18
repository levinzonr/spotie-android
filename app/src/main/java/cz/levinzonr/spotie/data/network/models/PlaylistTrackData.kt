package cz.levinzonr.spotie.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class PlaylistTrackData(val track: TrackResponse)