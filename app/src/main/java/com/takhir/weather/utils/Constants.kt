package com.takhir.weather.utils

class Constants {
  companion object {
    enum class CityType(val type: String) {
      SMALL("small"),
      MIDDLE("middle"),
      BIG("big")
    }
  }
}