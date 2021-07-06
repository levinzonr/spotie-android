package cz.levinzonr.spotie.data.mappers

import com.spotify.protocol.types.Track as SpotifyTrack
import cz.levinzonr.spotie.domain.models.DtoMapper
import cz.levinzonr.spotie.domain.models.Track

object SpotifyTrackResponseMapper : DtoMapper<SpotifyTrack, Track> {
    override fun toDomain(dto: SpotifyTrack): Track {
        return Track(
            id = dto.uri,
            title = dto.name,
            imageUrl = dto.imageUri.raw,
            artistName = dto.artist.name
        )
    }
}