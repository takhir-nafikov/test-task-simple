package com.takhir.weather.utils

import androidx.room.TypeConverter

class MonthsConverter {
  companion object {
    private const val SEPARATOR = ","
  }

  @TypeConverter
  fun fromMonths(months: List<String>) : String {
    return months.joinToString(separator = SEPARATOR)
  }

  @TypeConverter
  fun toMonths(data: String) : List<String> {
    return data.split(SEPARATOR)
  }
}