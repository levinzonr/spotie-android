package cz.levinzonr.spotie.domain.repositories

import cz.levinzonr.spotie.domain.models.TrackFeatures

interface TrackFeaturesRepository {
    suspend fun getTrackFeatures(trackId: String): TrackFeatures
}
