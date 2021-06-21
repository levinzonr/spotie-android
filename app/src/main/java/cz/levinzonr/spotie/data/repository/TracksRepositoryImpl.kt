package cz.levinzonr.spotie.data.repository

import cz.levinzonr.spotie.data.mappers.TracksResponseMapper
import cz.levinzonr.spotie.data.network.Api
import cz.levinzonr.spotie.domain.models.TimeRange
import cz.levinzonr.spotie.domain.models.Track
import cz.levinzonr.spotie.domain.models.mapWith
import cz.levinzonr.spotie.domain.repositories.TracksRepository
import javax.inject.Inject

class TracksRepositoryImpl @Inject constructor(
    private val api: Api
) : TracksRepository {
    override suspend fun getTopTracksFromTimeRange(timeRange: TimeRange): List<Track> {
        val response = api.getTopUserTracksAsync(timeRange.value)
        return response.items.mapWith(TracksResponseMapper)
    }

    override suspend fun getTrackDetails(id: String): Track {
        return Track("", "", "")
    }
}