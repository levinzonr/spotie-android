package cz.levinzonr.spotie.data.network

import cz.levinzonr.spotie.domain.repositories.TokenRepository
import okhttp3.Interceptor
import okhttp3.Response

class AuthTokenInterceptor(private val tokenRepository: TokenRepository) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
                .newBuilder()
        tokenRepository.token?.let {
            request.header("Authorization", "Bearer $it") }
        return chain.proceed(request.build())
    }
}