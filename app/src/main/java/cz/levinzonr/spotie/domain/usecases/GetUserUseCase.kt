package cz.levinzonr.spotie.domain.usecases

import cz.levinzonr.spotie.domain.repositories.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend fun getUser() = safeUseCaseCall {
        userRepository.getUser()
    }
}