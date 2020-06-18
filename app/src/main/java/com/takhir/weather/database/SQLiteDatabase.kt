package com.takhir.weather.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.takhir.weather.database.entity.CityEntity
import com.takhir.weather.database.entity.CityTemperatureEntity

@Database(
  version = 1,
  exportSchema = false,
  entities = [
    CityEntity::class,
    CityTemperatureEntity::class
  ]
)
abstract class SQLiteDatabase : RoomDatabase() {
  companion object {
    private const val DATABASE_NAME = "data.db"

    @JvmStatic
    private var instance: SQLiteDatabase? = null

    @JvmStatic
    fun getInstance(context: Context): SQLiteDatabase {
      synchronized(SQLiteDatabase::class.java) {
        if (instance !is SQLiteDatabase) {
          instance = Room
            .databaseBuilder(context, SQLiteDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
        }

        return instance !!
      }
    }
  }

//  abstract val storageDao: StorageDao
}