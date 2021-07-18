package cz.levinzonr.spotie.domain.repositories

import cz.levinzonr.spotie.domain.models.TimeRange
import cz.levinzonr.spotie.domain.models.Track

interface TracksRepository {
    suspend fun getTopTracksFromTimeRange(timeRange: TimeRange): List<Track>
    suspend fun getTrackDetails(id: String): Track
    suspend fun getTracksFromPlaylist(playlistId: String) : List<Track>
}
