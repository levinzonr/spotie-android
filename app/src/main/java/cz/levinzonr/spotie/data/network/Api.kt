package cz.levinzonr.spotie.data.network

import cz.levinzonr.spotie.data.network.models.*
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
    suspend fun getAudioFeatures(@Path("id") trackId: String): TrackFeaturesResponse

    @GET("v1/search?type=playlist&offset=0&limit=20")
    suspend fun searchPlaylists(
        @Query("q") query: String
    ) : PlaylistsResponse

    @GET("v1/playlists/{playlist_id}/tracks")
    suspend fun getTracksFromPlaylist(
        @Path("playlist_id") playlistId: String
    ) : PlaylistTracksPaginatedResponse
}
