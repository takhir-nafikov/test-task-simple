package com.takhir.weather.repository

import android.content.Context
import com.takhir.weather.database.DBClient
import com.takhir.weather.database.entity.CityEntity
import com.takhir.weather.database.entity.CityTemperatureEntity
import com.takhir.weather.executor.JobExecutor
import java.lang.Exception

class StorageRepository(
  private val context: Context,
  private val dbClient: DBClient,
  private val jobExecutor: JobExecutor
) : BaseRepository(jobExecutor) {

  fun getAllCities() = buildSingle<List<CityEntity>> { emitter ->
    try {
      val res = dbClient.instance.storageDao.getAllCities()
      emitter.onSuccess(res)
    } catch (e: Exception) {
      emitter.onError(e)
    }
  }

  fun insertCity(value: CityEntity) = buildCompletable { emitter ->
    try {
      dbClient.instance.storageDao.insertCity(value)
      emitter.onComplete()
    } catch (e: Exception) {
      emitter.onError(e)
    }
  }

  fun updateCity(value: CityEntity) = buildCompletable { emitter ->
    try {
      dbClient.instance.storageDao.updateCity(value)
      emitter.onComplete()
    } catch (e: Exception) {
      emitter.onError(e)
    }
  }

  fun deleteCity(value: CityEntity) = buildCompletable { emitter ->
    try {
      dbClient.instance.storageDao.deleteCity(value)
      emitter.onComplete()
    } catch (e: Exception) {
      emitter.onError(e)
    }
  }

  fun getCityTemperature(id : Int) = buildSingle<CityTemperatureEntity> { emitter ->  
    try {
      val res = dbClient.instance.storageDao.getCityTemperature(id)
      emitter.onSuccess(res)
    } catch (e: Exception) {
      emitter.onError(e)
    }
  }
  
  fun insertCityTemperature(value: CityTemperatureEntity) = buildCompletable { emitter ->  
    try {
      dbClient.instance.storageDao.insertCityTemperature(value)
    } catch (e: Exception) {
      emitter.onError(e)
    }
  }

  fun updateCityTemperature(value: CityTemperatureEntity) = buildCompletable { emitter ->
    try {
      dbClient.instance.storageDao.updateCityTemperature(value)
    } catch (e: Exception) {
      emitter.onError(e)
    }
  }

  fun deleteCityTemperature(value: CityTemperatureEntity) = buildCompletable { emitter ->
    try {
      dbClient.instance.storageDao.deleteCityTemperature(value)
    } catch (e: Exception) {
      emitter.onError(e)
    }
  }
}