package cz.levinzonr.spotie.domain.usecases

import cz.levinzonr.spotie.domain.models.TrackDetails
import cz.levinzonr.spotie.domain.repositories.TrackFeaturesRepository
import cz.levinzonr.spotie.domain.repositories.TracksRepository
import javax.inject.Inject

class GetTrackDetailsUseCase @Inject constructor(
    private val repository: TracksRepository,
    private val featuresRepository: TrackFeaturesRepository,
) {
    suspend fun getTrackDetails(id: String): UseCaseResult<TrackDetails> = safeUseCaseCall {
        val track = repository.getTrackDetails(id)
        val features = featuresRepository.getTrackFeatures(id)
        TrackDetails(track, features)
    }
}
