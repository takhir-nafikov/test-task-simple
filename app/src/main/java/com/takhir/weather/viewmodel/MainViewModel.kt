package com.takhir.weather.viewmodel

import com.takhir.weather.Navigation
import com.takhir.weather.database.entity.CityEntity
import com.takhir.weather.repository.StorageRepository
import com.takhir.weather.utils.Constants

class MainViewModel(
  private val navigation: Navigation,
  private val storageRepository: StorageRepository
) : BaseViewModel() {

  private var handlerAdapter: HandlerAdapter? = null

  fun setHandler(handler: HandlerAdapter) {
    handlerAdapter = handler
  }

  fun getAllCities() {
    addDisposable(
      storageRepository.getAllCities()
        .subscribe({
          handlerAdapter?.add(it)
        }, {

        })
    )
  }

  fun getCityByType(type: String) {
    addDisposable(
      storageRepository.getCityByType(type)
        .subscribe({
          handlerAdapter?.add(it)
        }, {

        })
    )
  }

  fun toDetailActivity(entity: CityEntity?) {
    navigation.toDetail(entity)
  }

  fun chooseCityType(pos: Int) {
    when(pos) {
      0 -> getAllCities()
      1 -> getCityByType(Constants.Companion.CityType.BIG.type)
      2 -> getCityByType(Constants.Companion.CityType.MIDDLE.type)
      3 -> getCityByType(Constants.Companion.CityType.SMALL.type)
      else -> getAllCities()
    }
  }
}

interface HandlerAdapter {
  fun add(data: List<CityEntity>)
}