package cz.levinzonr.spotie.data.mappers

import cz.levinzonr.spotie.domain.models.DtoMapper
import cz.levinzonr.spotie.domain.models.Track
import com.spotify.protocol.types.Track as SpotifyTrack

object SpotifyTrackResponseMapper : DtoMapper<SpotifyTrack, Track> {
    override fun toDomain(dto: SpotifyTrack): Track {
        return Track(
            id = dto.uri.split(":").last(),
            title = dto.name,
            imageUrl = null,
            artistName = dto.artist.name
        )
    }
}
