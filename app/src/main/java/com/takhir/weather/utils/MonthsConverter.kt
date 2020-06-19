package com.takhir.weather.utils

import androidx.room.TypeConverter

class MonthsConverter {
  companion object {
    private const val SEPARATOR = ","
  }

  @TypeConverter
  fun fromMonths(months: List<Float>) : String {
    return months.joinToString(separator = SEPARATOR)
  }

  @TypeConverter
  fun toMonths(data: String) : List<Float> {
    val list = data.split(SEPARATOR)
    return list.map { it.toFloat() }
  }
}