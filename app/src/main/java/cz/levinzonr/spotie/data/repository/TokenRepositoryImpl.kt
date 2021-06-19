package cz.levinzonr.spotie.data.repository

import cz.levinzonr.spotie.domain.manager.PrefManager
import cz.levinzonr.spotie.domain.repositories.TokenRepository
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
    private val prefManager: PrefManager
) : TokenRepository {

    companion object {
        private const val PREF_TOKEN = "token"
    }

    override fun get(): String? = prefManager.getString(PREF_TOKEN)

    override fun set(token: String) = prefManager.setString(PREF_TOKEN, token)
}