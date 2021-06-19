package cz.levinzonr.spotie.domain.usecases

sealed interface UseCaseResult<out T> {
    data class Success<T>(val data: T) : UseCaseResult<T>
    data class Error(val throwable: Throwable) : UseCaseResult<Nothing>
}

suspend fun <T> safeUseCaseCall(block: suspend () -> T): UseCaseResult<T> {
    return try {
        UseCaseResult.Success(block.invoke())
    } catch (t: Throwable) {
        UseCaseResult.Error(t)
    }
}

suspend fun <T> UseCaseResult<T>.ifSuccess(block: suspend (T) -> Unit): UseCaseResult<T> {
    if (this is UseCaseResult.Success) block.invoke(data)
    return this
}

suspend fun <T> UseCaseResult<T>.ifError(block: suspend (Throwable) -> Unit): UseCaseResult<T> {
    if (this is UseCaseResult.Error) block.invoke(throwable)
    return this
}
