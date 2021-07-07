package cz.levinzonr.spotie.domain.usecases.player

import cz.levinzonr.spotie.domain.manager.PlayerManager
import cz.levinzonr.spotie.domain.usecases.safeUseCaseCall
import javax.inject.Inject

class PlayNextUseCase @Inject constructor(
    private val playerManager: PlayerManager
) {
    suspend fun next() = safeUseCaseCall {
        playerManager.next()
    }
}
