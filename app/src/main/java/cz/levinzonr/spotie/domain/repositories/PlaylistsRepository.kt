package cz.levinzonr.spotie.domain.repositories

import cz.levinzonr.spotie.domain.models.Playlist
import cz.levinzonr.spotie.domain.models.Track

interface PlaylistsRepository {
    suspend fun searchPlaylists(query: String) : List<Playlist>

    suspend fun getUserPlaylists() : List<Playlist>

    suspend fun addItemsToPlaylist(playlistId: String, uri: List<String>)
}