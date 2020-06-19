package com.takhir.weather.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.TypeConverters
import com.takhir.weather.utils.MonthsConverter

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
  @TypeConverters(MonthsConverter::class)
  val months: List<Float>,
  val cityId: Int
)