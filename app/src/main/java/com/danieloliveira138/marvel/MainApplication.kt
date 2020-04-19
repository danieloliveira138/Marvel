package com.danieloliveira138.marvel

import android.app.Application
import com.danieloliveira138.marvel.di.appModule
import com.danieloliveira138.marvel.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@Suppress("unused")
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = if (BuildConfig.DEBUG) Level.DEBUG else Level.ERROR)
            androidContext(this@MainApplication)
            modules(listOf(appModule, viewModelModule))
        }
    }
}