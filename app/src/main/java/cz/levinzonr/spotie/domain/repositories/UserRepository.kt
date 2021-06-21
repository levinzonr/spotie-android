package cz.levinzonr.spotie.domain.repositories

import cz.levinzonr.spotie.domain.models.User

interface UserRepository {
    suspend fun getUser(): User
}
