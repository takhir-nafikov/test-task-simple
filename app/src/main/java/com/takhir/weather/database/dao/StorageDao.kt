package com.takhir.weather.database.dao

import androidx.room.*
import com.takhir.weather.database.entity.CityData
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
  @Query(value = "SELECT cities.name, cities.type, temperature.value " +
      "FROM cities, temperature WHERE cities.id == temperature.cityId")
  fun getCityTemperature() : CityData

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertCityTemperature(value: CityTemperatureEntity)

  @Update
  fun updateCityTemperature(value: CityTemperatureEntity)

  @Delete
  fun deleteCityTemperature(value: CityTemperatureEntity)
}