package com.orbitalsonic.appslanguagechange

import android.app.Application
import android.content.res.Configuration
import android.content.res.Resources
import com.orbitalsonic.appslanguagechange.SharedPreferencesUtils.getLanguageCode
import java.util.*

class MainApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        // this setting for default actionbar title
//        setLocale(getLanguageCode(this))
    }

    private fun setLocale(locale: String) {
        Locale.setDefault(Locale(locale))
        val resources: Resources = resources
        val config: Configuration = resources.configuration
        config.setLocale(Locale(locale))
        resources.updateConfiguration(config, resources.displayMetrics)
    }

}