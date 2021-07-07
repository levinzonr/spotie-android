package cz.levinzonr.spotie.presentation.screens.player

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.levinzonr.spotie.domain.models.PlayerState
import cz.levinzonr.spotie.domain.usecases.player.PlayNextUseCase
import cz.levinzonr.spotie.domain.usecases.player.PlayPreviousUseCase
import cz.levinzonr.spotie.domain.usecases.player.PlayerStateUseCase
import cz.levinzonr.spotie.domain.usecases.player.TogglePlaybackUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val togglePlaybackUseCase: TogglePlaybackUseCase,
    private val playNextUseCase: PlayNextUseCase,
    private val playPreviousUseCase: PlayPreviousUseCase,
    private val getPlayerStateUseCase: PlayerStateUseCase
) : ViewModel() {

    val stateFlow : Flow<PlayerState> get() = playerStateFlow
    private val playerStateFlow = getPlayerStateUseCase.getPlayerState()

    init {
        playerStateFlow.launchIn(viewModelScope)
    }

    fun dispatch(action: PlayerAction) = viewModelScope.launch {
        when(action) {
            is PlayerAction.Next -> playNextUseCase.next()
            is PlayerAction.Previous -> playPreviousUseCase.previous()
            is PlayerAction.Toggle -> togglePlaybackUseCase.toggle()
        }
    }
}