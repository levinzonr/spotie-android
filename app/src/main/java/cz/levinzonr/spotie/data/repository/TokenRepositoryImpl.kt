package cz.levinzonr.spotie.data.repository

import cz.levinzonr.spotie.domain.manager.PrefManager
import cz.levinzonr.spotie.domain.repositories.TokenRepository
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
    private val prefManager: PrefManager
) : TokenRepository {

    companion object {
        private const val PREF_TOKEN = "token"
        private const val PREF_REFRESH_TOKEN = "refresh_token"
    }

    override var token: String?
        get() = prefManager.getString(PREF_TOKEN)
        set(value) = prefManager.setString(PREF_TOKEN, value)


    override var refreshToken: String?
        get() = prefManager.getString(PREF_REFRESH_TOKEN)
        set(value) = prefManager.setString(PREF_REFRESH_TOKEN, value)

}