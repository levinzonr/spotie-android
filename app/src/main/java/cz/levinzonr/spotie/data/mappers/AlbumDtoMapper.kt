package cz.levinzonr.spotie.data.mappers

import cz.levinzonr.spotie.domain.models.Album
import cz.levinzonr.spotie.data.network.models.AlbumData
import cz.levinzonr.spotie.domain.models.DtoMapper

object AlbumDtoMapper : DtoMapper<AlbumData, Album> {
    override fun toDomain(dto: AlbumData): Album {
        return Album(
            id = dto.id,
            title = dto.name,
            type = dto.album_type,
            tracksCount = dto.total_tracks,
            releaseDate = dto.release_date,
            image = dto.images.firstOrNull()?.url
        )
    }
}