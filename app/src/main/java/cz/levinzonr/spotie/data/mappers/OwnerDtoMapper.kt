package cz.levinzonr.spotie.data.mappers

import cz.levinzonr.spotie.data.network.models.OwnerData
import cz.levinzonr.spotie.domain.models.DtoMapper
import cz.levinzonr.spotie.domain.models.Owner

object OwnerDtoMapper: DtoMapper<OwnerData, Owner> {
    override fun toDomain(dto: OwnerData): Owner {
        return Owner(
            id = dto.id,
            type = dto.type,
            uri = dto.uri
        )
    }
}