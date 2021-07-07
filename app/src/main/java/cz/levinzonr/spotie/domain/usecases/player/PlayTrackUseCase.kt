package cz.levinzonr.spotie.domain.usecases.player

import cz.levinzonr.spotie.domain.manager.PlayerManager
import cz.levinzonr.spotie.domain.usecases.safeUseCaseCall
import javax.inject.Inject

class PlayTrackUseCase @Inject constructor(
    private val playerManager: PlayerManager
) {
    suspend fun play(trackId: String) = safeUseCaseCall {
        val uri = "spotify:track:$trackId"
        playerManager.play(trackId)
    }
}