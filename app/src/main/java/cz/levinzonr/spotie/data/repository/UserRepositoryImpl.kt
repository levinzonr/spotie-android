package cz.levinzonr.spotie.data.repository

import cz.levinzonr.spotie.data.mappers.UserResponseMapper
import cz.levinzonr.spotie.data.network.Api
import cz.levinzonr.spotie.domain.models.User
import cz.levinzonr.spotie.domain.repositories.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: Api
) : UserRepository {
    override suspend fun getUser(): User {
        return UserResponseMapper.toDomain(api.getCurrentUserProfile())
    }
}