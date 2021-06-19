package cz.levinzonr.spotie.data.storage

import android.content.Context
import androidx.preference.PreferenceManager
import cz.levinzonr.spotie.domain.manager.PrefManager
import javax.inject.Inject

class PrefManagerImpl @Inject constructor(
    private val context: Context
) : PrefManager {

    private val prefs = PreferenceManager.getDefaultSharedPreferences(context)

    override fun setString(key: String, value: String?) {
        prefs.edit().putString(key, value).apply()
    }

    override fun getString(key: String): String? {
        return prefs.getString(key, null)
    }

    override fun remove(key: String) {
        prefs.edit().remove(key).apply()
    }
}
