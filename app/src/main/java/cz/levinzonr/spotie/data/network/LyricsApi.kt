package cz.levinzonr.spotie.data.network

import cz.levinzonr.spotie.data.network.models.LyricsTrackResponse

interface LyricsApi {

    suspend fun searchTrack(query: String) : LyricsTrackResponse

}