package cz.levinzonr.spotie.data.repository

import cz.levinzonr.spotie.data.mappers.TrackFeaturesMapper
import cz.levinzonr.spotie.data.network.Api
import cz.levinzonr.spotie.domain.models.TrackFeatures
import cz.levinzonr.spotie.domain.repositories.TrackFeaturesRepository
import javax.inject.Inject

class TrackFeaturesRepositoryImpl @Inject constructor(
    private val api: Api
) : TrackFeaturesRepository {
    override suspend fun getTrackFeatures(trackId: String): TrackFeatures {
        return api.getAudioFeatures(trackId).let(TrackFeaturesMapper::toDomain)
    }
}
