package cz.levinzonr.spotie.domain.usecases

import cz.levinzonr.spotie.domain.models.NewRelease
import cz.levinzonr.spotie.domain.models.Playlist
import cz.levinzonr.spotie.domain.repositories.PlaylistsRepository
import javax.inject.Inject

class AddReleaseToPlaylistUseCase @Inject constructor(
    private val repository: PlaylistsRepository
) {
    suspend fun addRelease(playlist: Playlist, release: NewRelease) = safeUseCaseCall {
        repository.addItemsToPlaylist(
            playlistId = playlist.id,
            uri = listOf(release.album.uri)
        )
    }
}