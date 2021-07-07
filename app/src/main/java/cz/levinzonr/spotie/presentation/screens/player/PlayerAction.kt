package cz.levinzonr.spotie.presentation.screens.player

sealed interface PlayerAction {
    object Toggle: PlayerAction
    object Next: PlayerAction
    object Previous: PlayerAction
}