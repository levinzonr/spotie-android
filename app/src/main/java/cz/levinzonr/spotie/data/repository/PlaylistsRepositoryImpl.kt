package cz.levinzonr.spotie.data.repository

import cz.levinzonr.spotie.data.mappers.PlaylistResponseMapper
import cz.levinzonr.spotie.data.network.Api
import cz.levinzonr.spotie.domain.models.Playlist
import cz.levinzonr.spotie.domain.models.mapWith
import cz.levinzonr.spotie.domain.repositories.PlaylistsRepository
import javax.inject.Inject

class PlaylistsRepositoryImpl @Inject constructor(
    private val api: Api
) : PlaylistsRepository {

    override suspend fun searchPlaylists(query: String): List<Playlist> {
        return api.searchPlaylists(query).playlists.items.mapWith(PlaylistResponseMapper)
    }

}