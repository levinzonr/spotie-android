package cz.levinzonr.spotie.domain.models

sealed interface PlayerState {
    object Idle: PlayerState
    data class Ready(val track: Track, val isPlaying: Boolean) : PlayerState
    data class Error(val throwable: Throwable) : PlayerState
}