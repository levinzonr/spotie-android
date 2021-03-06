package cz.levinzonr.spotie.domain.usecases

import cz.levinzonr.spotie.domain.repositories.ModelRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class GetModelUseCase @Inject constructor(val repository: ModelRepository) {

    suspend fun get(): UseCaseResult<String> = safeUseCaseCall {
        delay(1000)
        "data"
    }
}
