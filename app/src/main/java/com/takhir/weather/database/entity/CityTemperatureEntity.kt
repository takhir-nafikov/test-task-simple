package com.takhir.weather.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
  tableName = "temperature",
  primaryKeys = ["id"],
  foreignKeys = [ForeignKey(
    entity = CityEntity::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("cityId"),
    onDelete = ForeignKey.CASCADE
  )]
)
data class CityTemperatureEntity(
  val id: Int,
  val value: Float,
  val cityId: Int
)