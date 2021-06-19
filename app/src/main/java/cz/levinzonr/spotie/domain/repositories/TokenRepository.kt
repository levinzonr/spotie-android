package cz.levinzonr.spotie.domain.repositories

interface TokenRepository {
    fun get() : String?
    fun set(token: String)
}