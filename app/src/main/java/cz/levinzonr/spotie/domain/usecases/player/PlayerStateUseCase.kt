package cz.levinzonr.spotie.domain.usecases.player

import cz.levinzonr.spotie.domain.manager.PlayerManager
import cz.levinzonr.spotie.domain.models.PlayerState
import cz.levinzonr.spotie.domain.repositories.TracksRepository
import cz.levinzonr.spotie.domain.usecases.GetTrackDetailsUseCase
import cz.levinzonr.spotie.domain.usecases.UseCaseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest
import javax.inject.Inject

class PlayerStateUseCase @Inject constructor(
    private val playerManager: PlayerManager,
    private val getTrackDetailsUseCase: GetTrackDetailsUseCase
) {
    fun getPlayerState() : Flow<PlayerState> {
        return playerManager.playerStateFlow
            .mapLatest {
                if (it is PlayerState.Ready && it.track.imageUrl == null) {
                    val imageUrl = tryLoadingImage(it.track.id)
                    PlayerState.Ready(it.track.copy(imageUrl = imageUrl), it.isPlaying)
                } else {
                    it
                }
            }
    }

    private suspend fun tryLoadingImage(id: String) : String? {
       return getTrackDetailsUseCase.getTrackDetails(id).let {
           it as? UseCaseResult.Success?
       }?.data?.track?.imageUrl
    }
}
