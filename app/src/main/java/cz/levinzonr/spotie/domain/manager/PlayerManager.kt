package cz.levinzonr.spotie.domain.manager

import cz.levinzonr.spotie.domain.models.PlayerState
import kotlinx.coroutines.flow.Flow

interface PlayerManager {

    val playerStateFlow: Flow<PlayerState>

    suspend fun play(trackId: String)
    suspend fun next()
    suspend fun pause()
    suspend fun toggle()
    suspend fun previous()
    suspend fun addToQueue(trackId: String)
    suspend fun shuffle(shuffle: Boolean)
    fun connect()
    fun disconnect()
}
