package com.takhir.weather.database.dao

import androidx.room.*
import com.takhir.weather.database.entity.CityEntity

@Dao
interface StorageDao {

  @Query(value = "SELECT * FROM cities")
  fun getAllCities() : List<CityEntity>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertCity(value: CityEntity)

  @Update
  fun updateCity(value: CityEntity)

  @Delete
  fun deleteCity(value: CityEntity)

  @Query(value = "SELECT COUNT(*) FROM cities")
  fun getCount() : Int

  @Query(value = "SELECT * FROM cities WHERE cities.type =:type")
  fun getCityByType(type: String) : List<CityEntity>
}