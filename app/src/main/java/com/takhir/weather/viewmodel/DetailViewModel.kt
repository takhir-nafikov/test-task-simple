package com.takhir.weather.viewmodel

import androidx.databinding.ObservableField
import com.takhir.weather.Navigation
import com.takhir.weather.database.entity.CityEntity
import com.takhir.weather.repository.StorageRepository
import com.takhir.weather.utils.Constants

class DetailViewModel(
  private val navigation: Navigation,
  private val storageRepository: StorageRepository
) : BaseViewModel() {


  //val months = ObservableArrayList<String>()
  val name = ObservableField<String>()

  val entity = ObservableField<CityEntity?>()

  var cityType: Constants.Companion.CityType? = null

  fun setEntity(value: CityEntity?) {
    entity.set(value)
    name.set(value?.name)

  }

  fun setType(index: Int) {
    cityType = when (index) {
      0 -> Constants.Companion.CityType.BIG
      1 -> Constants.Companion.CityType.MIDDLE
      2 -> Constants.Companion.CityType.SMALL
      else -> Constants.Companion.CityType.BIG
    }
  }

  fun addEntity() {
    val e = CityEntity.factory(
      id = 0,
      name = name.get() ?: "Default name",
      type = cityType?.type ?: Constants.Companion.CityType.BIG.type
    )

    addDisposable(
      storageRepository.insertCity(e)
        .subscribe({
          toMain()
        }, {

        })
    )
  }

  fun updateEntity() {
    val e = CityEntity.factory(
      entity.get()?.id!!,
      name.get() ?: "Default Name",
      cityType?.type ?: entity.get()?.type!!
    )

    addDisposable(
      storageRepository.updateCity(e)
        .subscribe({
          toMain()
        }, {

        })
    )
  }

  fun deleteEntity() {
    addDisposable(
      storageRepository.deleteCity(entity.get()!!)
        .subscribe({
          toMain()
        }, {

        })
    )
  }

  fun toMain() {
    navigation.toMain()
  }
}