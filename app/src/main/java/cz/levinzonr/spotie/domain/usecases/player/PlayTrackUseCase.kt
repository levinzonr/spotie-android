package cz.levinzonr.spotie.domain.usecases.player

import cz.levinzonr.spotie.domain.manager.PlayerManager
import cz.levinzonr.spotie.domain.models.PlayerState
import cz.levinzonr.spotie.domain.usecases.safeUseCaseCall
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class PlayTrackUseCase @Inject constructor(
    private val playerManager: PlayerManager
) {
    suspend fun play(trackId: String) = safeUseCaseCall {
        val isPlaying = playerManager.playerStateFlow.firstOrNull()?.let { it as? PlayerState.Ready }?.isPlaying
        if (isPlaying == true) {
            playerManager.pause()
        } else {
            val uri = "spotify:track:$trackId"
            playerManager.play(uri)
        }
    }
}
