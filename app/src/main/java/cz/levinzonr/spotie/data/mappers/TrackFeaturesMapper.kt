package cz.levinzonr.spotie.data.mappers

import cz.levinzonr.spotie.data.network.models.TrackFeaturesResponse
import cz.levinzonr.spotie.domain.models.DtoMapper
import cz.levinzonr.spotie.domain.models.TrackFeatures

object TrackFeaturesMapper : DtoMapper<TrackFeaturesResponse, TrackFeatures> {
    override fun toDomain(dto: TrackFeaturesResponse): TrackFeatures {
        return TrackFeatures(
            rhythm = dto.tempo,
            energy = dto.energy,
            danceability = dto.danceability,
            durationMs = dto.duration_ms
        )
    }
}
