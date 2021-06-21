package cz.levinzonr.spotie.domain.models

interface DtoMapper<DTO, Domain> {
    fun toDomain(dto: DTO): Domain
}
