package cz.levinzonr.spotie.domain.usecases

import cz.levinzonr.spotie.domain.models.TimeRange
import cz.levinzonr.spotie.domain.models.TopTracks
import cz.levinzonr.spotie.domain.repositories.TracksRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class GetTopTracksUseCase @Inject constructor(
    private val tracksRepository: TracksRepository
) {
    suspend fun getTopTracks() = safeUseCaseCall {
        coroutineScope {
            val midDeferred = async { tracksRepository.getTopTracksFromTimeRange(TimeRange.Mid) }
            val longDeferred = async { tracksRepository.getTopTracksFromTimeRange(TimeRange.Long) }
            val shortDeferred = async { tracksRepository.getTopTracksFromTimeRange(TimeRange.Short) }
            TopTracks(
                shortTerm = shortDeferred.await(),
                longTerm = longDeferred.await(),
                midTerm = midDeferred.await()
            )
        }
    }
}