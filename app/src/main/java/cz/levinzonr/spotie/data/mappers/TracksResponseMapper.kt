package cz.levinzonr.spotie.data.mappers

import cz.levinzonr.spotie.data.network.models.TrackResponse
import cz.levinzonr.spotie.domain.models.DtoMapper
import cz.levinzonr.spotie.domain.models.Track

object TracksResponseMapper : DtoMapper<TrackResponse, Track> {
    override fun toDomain(dto: TrackResponse): Track {
        return Track(
            id = dto.id,
            title = dto.name,
            imageUrl = dto.album.images.firstOrNull()?.url,
            artistName = dto.artists.firstOrNull()?.name ?: ""
        )
    }
}
