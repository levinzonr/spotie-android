package cz.levinzonr.spotie.injection

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import cz.levinzonr.spotie.BuildConfig
import cz.levinzonr.spotie.data.network.Api
import cz.levinzonr.spotie.data.network.AppAuthenticator
import cz.levinzonr.spotie.data.network.AuthApi
import cz.levinzonr.spotie.data.network.AuthTokenInterceptor
import cz.levinzonr.spotie.domain.repositories.TokenRepository
import cz.levinzonr.spotie.domain.usecases.RefreshTokenUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val CLIENT_API = "client_api"
    private const val CLIENT_AUTH = "client_auth"

    private const val RETROFIT_API = "retrofit_api"
    private const val RETROFIT_AUTH = "retrofit_auth"

    @Provides
    fun provideConverter() : Converter.Factory {
        val contentType = "application/json".toMediaType()
        return Json {
            this.
            ignoreUnknownKeys = true
        }.asConverterFactory(contentType)
    }

    @Provides
    @Singleton
    @Named(CLIENT_API)
    fun provideHttpClient(tokenRepository: TokenRepository, refreshTokenUseCase: RefreshTokenUseCase): OkHttpClient {
        val interceptor = AuthTokenInterceptor(tokenRepository)
        val authenticator = AppAuthenticator(refreshTokenUseCase)

        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout(45, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(interceptor)

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(logging)
        }

        return clientBuilder.build()
    }


    @Provides
    @Singleton
    @Named(CLIENT_AUTH)
    fun provideAuthHttpClient(): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout(45, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(logging)
        }

        return clientBuilder.build()
    }

    @Provides
    @Singleton
    @Named(RETROFIT_API)
    fun provideRetrofit(
        @Named(CLIENT_API) client: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    @Singleton
    @Named(RETROFIT_AUTH)
    fun provideAuthRetrofit(
        @Named(CLIENT_AUTH) client: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.API_AUTH_URL)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(@Named(RETROFIT_API) retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthApi(@Named(RETROFIT_AUTH) retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }
}
