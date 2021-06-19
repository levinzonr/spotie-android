package cz.levinzonr.spotie.data.network

import cz.levinzonr.spotie.data.network.models.AuthResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("api/token")
    suspend fun obtainAccessTokenAsync(
        @Field("code") code: String,
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("grant_type") grant: String = "authorization_code",
        @Field("redirect_uri") uri: String = "yourcustomprotocol://callback"
    ) : AuthResponse


    @FormUrlEncoded
    @POST("api/token")
    suspend fun refreshAccessToken(
        @Field("refresh_token") refreshToken: String,
        @Header("Authorization") authHeader: String,
        @Field("grant_type") grant: String = "refresh_token"
    ) : AuthResponse



}