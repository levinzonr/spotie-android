package cz.levinzonr.spotie.data.network

import cz.levinzonr.spotie.data.network.models.PaginatedResponse
import cz.levinzonr.spotie.data.network.models.TrackFeaturesResponse
import cz.levinzonr.spotie.data.network.models.TrackResponse
import cz.levinzonr.spotie.data.network.models.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("v1/me")
    suspend fun getCurrentUserProfile(): UserResponse

    @GET("v1/me/top/tracks")
    suspend fun getTopUserTracksAsync(@Query("time_range") timeRange: String): PaginatedResponse

    @GET("v1/tracks/{id}")
    suspend fun getTrackDetails(@Path("id") trackId: String): TrackResponse

    @GET("v1/audio-features/{id}")
    suspend fun getAudioFeatures(@Path("id") trackId: String) : TrackFeaturesResponse
}
