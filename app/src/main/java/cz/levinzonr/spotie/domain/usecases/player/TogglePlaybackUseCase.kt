package cz.levinzonr.spotie.domain.usecases.player

import cz.levinzonr.spotie.domain.manager.PlayerManager
import cz.levinzonr.spotie.domain.usecases.safeUseCaseCall
import javax.inject.Inject

class TogglePlaybackUseCase @Inject constructor(
    private val playerManager: PlayerManager
) {
    suspend fun toggle() = safeUseCaseCall {
        playerManager.toggle()
    }
}