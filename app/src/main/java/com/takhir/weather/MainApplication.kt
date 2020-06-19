package com.takhir.weather

import android.app.Application
import com.takhir.weather.di.KoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    startKoin {
      printLogger(Level.DEBUG)

      androidContext(this@MainApplication)

      KoinModule.run {
        modules(
          listOf(
            androidModule,
            repositories,
            viewModels
          )
        )
      }
    }
  }
}