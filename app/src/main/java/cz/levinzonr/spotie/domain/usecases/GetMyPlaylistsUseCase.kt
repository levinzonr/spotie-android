package cz.levinzonr.spotie.domain.usecases

import cz.levinzonr.spotie.domain.models.Playlist
import cz.levinzonr.spotie.domain.repositories.PlaylistsRepository
import javax.inject.Inject

class GetMyPlaylistsUseCase @Inject constructor(
    private val repository: PlaylistsRepository
) {
    suspend fun getPlaylists(query: String = "") = safeUseCaseCall {
        val playlists = repository.getUserPlaylists()
        if (query.isBlank()) playlists else {
            playlists.filter { it.name.contains(query, true) }
        }
    }
}