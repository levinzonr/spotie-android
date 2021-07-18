package cz.levinzonr.spotie.domain.repositories

import cz.levinzonr.spotie.domain.models.Playlist

interface PlaylistsRepository {
    suspend fun searchPlaylists(query: String) : List<Playlist>
}