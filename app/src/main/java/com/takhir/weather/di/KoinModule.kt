package com.takhir.weather.di

import com.takhir.weather.database.DBClient
import com.takhir.weather.executor.JobExecutor
import org.koin.dsl.module

object KoinModule {
  val androidModule = module {
    single { DBClient(get()) }
    single { JobExecutor() }
  }

  val repositories = module {

  }

  val viewModels = module {

  }
}