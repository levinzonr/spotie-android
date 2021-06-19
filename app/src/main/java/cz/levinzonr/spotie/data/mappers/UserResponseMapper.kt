package cz.levinzonr.spotie.data.mappers

import cz.levinzonr.spotie.data.network.models.UserResponse
import cz.levinzonr.spotie.domain.models.DtoMapper
import cz.levinzonr.spotie.domain.models.User

object UserResponseMapper : DtoMapper<UserResponse, User> {
    override fun toDomain(dto: UserResponse): User {
        return User(
            displayName = dto.display_name,
            imageUrl = dto.images.firstOrNull()?.url
        )
    }
}