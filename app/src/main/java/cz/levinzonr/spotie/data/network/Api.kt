package cz.levinzonr.spotie.data.network

import cz.levinzonr.spotie.data.network.models.UserResponse
import retrofit2.http.GET

interface Api {

    @GET("v1/me")
    suspend fun getCurrentUserProfile(): UserResponse
}
