package com.takhir.weather.di

import com.takhir.weather.Navigation
import com.takhir.weather.database.DBClient
import com.takhir.weather.executor.JobExecutor
import com.takhir.weather.repository.StorageRepository
import com.takhir.weather.viewmodel.DetailViewModel
import com.takhir.weather.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object KoinModule {
  val androidModule = module {
    single { DBClient(get()) }
    single { JobExecutor() }
    single { Navigation(get()) }
  }

  val repositories = module {
    factory { StorageRepository(get(), get(), get()) }
  }

  val viewModels = module {
    viewModel { MainViewModel(get(), get()) }
    viewModel { DetailViewModel(get(), get()) }
  }
}