package cz.levinzonr.spotie.domain.models

interface DtoMapper<DTO, Domain> {
    fun toDomain(dto: DTO): Domain
}

fun <DTO, T> List<DTO>.mapWith(mapper: DtoMapper<DTO, T>): List<T> {
    return map { mapper.toDomain(it) }
}
