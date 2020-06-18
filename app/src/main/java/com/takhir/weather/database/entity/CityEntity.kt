package com.takhir.weather.database.entity

import androidx.room.Entity
import com.takhir.weather.utils.Constants

@Entity(
  tableName = "cities",
  primaryKeys = ["id"]
)
data class CityEntity(
  val id: Int,
  val name: String,
  val type: String
)