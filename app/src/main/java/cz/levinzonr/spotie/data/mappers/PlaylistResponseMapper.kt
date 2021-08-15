package cz.levinzonr.spotie.data.mappers

import cz.levinzonr.spotie.data.network.models.PlaylistResponse
import cz.levinzonr.spotie.domain.models.DtoMapper
import cz.levinzonr.spotie.domain.models.Playlist

object PlaylistResponseMapper : DtoMapper<PlaylistResponse, Playlist> {
    override fun toDomain(dto: PlaylistResponse): Playlist {
        return Playlist(
            id = dto.id,
            name = dto.name,
            isCollaborative = dto.collaborative,
            imageUrl = dto.images.firstOrNull()?.url
        )
    }
}