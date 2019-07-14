package com.mmozhaiskyi.chuwachi

import android.app.Application
import com.mmozhaiskyi.chuwachi.feature.setup.gameSetupModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(
                gameSetupModule
            )
        }
    }
}
