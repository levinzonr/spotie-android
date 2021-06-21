package cz.levinzonr.spotie.domain.repositories

interface TokenRepository {
    var token: String?
    var refreshToken: String?
}
