package com.mmozhaiskyi.chuwachi

import android.app.Application
import com.facebook.stetho.Stetho
import com.mmozhaiskyi.chuwachi.data.dataModule
import com.mmozhaiskyi.chuwachi.db.databaseModule
import com.mmozhaiskyi.chuwachi.feature.setup.gameSetupModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    dataModule,
                    databaseModule,
                    gameSetupModule
                )
            )
        }
    }
}
