package cz.levinzonr.spotie.data.network

import cz.levinzonr.spotie.domain.usecases.RefreshTokenUseCase
import cz.levinzonr.spotie.domain.usecases.UseCaseResult
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class AppAuthenticator(
    private val refreshTokenUseCase: RefreshTokenUseCase
) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        val result = runBlocking { refreshTokenUseCase.refresh() }
        return when (result) {
            is UseCaseResult.Error -> null
            is UseCaseResult.Success -> {
                response.request.newBuilder()
                    .header("Authorization", "Bearer ${result.data.accessToken}")
                    .build()
            }
        }
    }
}
