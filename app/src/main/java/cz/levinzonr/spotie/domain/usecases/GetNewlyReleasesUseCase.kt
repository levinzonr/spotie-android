package cz.levinzonr.spotie.domain.usecases

import cz.levinzonr.spotie.domain.models.Album
import cz.levinzonr.spotie.domain.models.NewRelease
import cz.levinzonr.spotie.domain.repositories.PlaylistsRepository
import cz.levinzonr.spotie.domain.repositories.TracksRepository
import javax.inject.Inject

class GetNewlyReleasesUseCase @Inject constructor(
    private val playlistsRepository: PlaylistsRepository,
    private val tracksRepository: TracksRepository
) {
    suspend fun getNewReleases() : UseCaseResult<List<NewRelease>> = safeUseCaseCall {
        val releaseRadar = playlistsRepository.searchPlaylists("release radar").firstOrNull()
        val tracks = tracksRepository.getTracksFromPlaylist(requireNotNull(releaseRadar).id)
        tracks.map { NewRelease(it.artistName, it.album) }
    }
}