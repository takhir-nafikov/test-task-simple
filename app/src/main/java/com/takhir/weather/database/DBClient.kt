package com.takhir.weather.database

import android.content.Context

class DBClient constructor(private val context: Context) {
  val instance: SQLiteDatabase by lazy { SQLiteDatabase.getInstance(context) }
}