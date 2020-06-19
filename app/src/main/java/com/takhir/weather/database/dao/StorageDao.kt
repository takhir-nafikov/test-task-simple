package com.takhir.weather.database.dao

import androidx.room.*
import com.takhir.weather.database.entity.CityEntity
import com.takhir.weather.database.entity.CityTemperatureEntity

@Dao
interface StorageDao {

  // City
  @Query(value = "SELECT * FROM cities")
  fun getAllCities() : List<CityEntity>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertCity(value: CityEntity)

  @Update
  fun updateCity(value: CityEntity)

  @Delete
  fun deleteCity(value: CityEntity)


  // Temperature
  @Query(value = "SELECT * FROM temperature WHERE cityId = :id")
  fun getCityTemperature(id: Int) : CityTemperatureEntity

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertCityTemperature(value: CityTemperatureEntity)

  @Update
  fun updateCityTemperature(value: CityTemperatureEntity)

  @Delete
  fun deleteCityTemperature(value: CityTemperatureEntity)
}