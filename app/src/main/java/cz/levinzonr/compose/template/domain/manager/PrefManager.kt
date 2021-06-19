package cz.levinzonr.compose.template.domain.manager

interface PrefManager {
    fun setString(key: String, value: String?)
    fun getString(key: String): String?
    fun remove(key: String)
}
