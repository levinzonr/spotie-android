package cz.levinzonr.spotie.domain.usecases.player

import cz.levinzonr.spotie.domain.manager.PlayerManager
import javax.inject.Inject

class PlayerStateUseCase @Inject constructor(
    private val playerManager: PlayerManager
) {
    fun getPlayerState() = playerManager.playerStateFlow
}
