package com.takhir.weather.database.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.takhir.weather.utils.Constants
import com.takhir.weather.utils.MonthsConverter
import kotlinx.android.parcel.Parcelize

@Entity(
  tableName = "cities",
  primaryKeys = ["id"]
)
@Parcelize
data class CityEntity(
  var id: Int,
  val name: String,
//  @TypeConverters(MonthsConverter::class)
//  val months: List<String>,
  val type: String
): Parcelable {
  companion object {
    fun factory(
      id: Int,
      name: String,
      type: String
    ) =
      CityEntity(
        id,
        name,
        type
      )
  }
}