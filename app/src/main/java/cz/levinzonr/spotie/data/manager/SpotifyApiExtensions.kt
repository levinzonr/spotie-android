package cz.levinzonr.spotie.data.manager

import com.spotify.android.appremote.api.PlayerApi
import com.spotify.protocol.client.CallResult
import com.spotify.protocol.types.PlayerState
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import timber.log.Timber


fun PlayerApi.stateFlow(): Flow<PlayerState> = callbackFlow {
    val eventSub = subscribeToPlayerState().setEventCallback {
        trySend(it)
    }
    val errorSub = subscribeToPlayerState().setErrorCallback {
        throw it
    }

    awaitClose {
        eventSub.cancel()
        errorSub.cancel()
        Timber.d("Close")
    }
}


fun CallResult<*>.awaitAndValidate() : Boolean {
    val result = await()
    return when {
        result.isSuccessful && result.data != null -> true
        else -> throw IllegalStateException(result.errorMessage ?: "")
    }
}