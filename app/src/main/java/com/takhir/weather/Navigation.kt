package com.takhir.weather

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.takhir.weather.database.entity.CityEntity
import com.takhir.weather.view.activity.DetailActivity
import com.takhir.weather.view.activity.MainActivity

class Navigation(private val context: Context) {

  private fun <T: Any> startActivity(clazz: Class<T>, bundle: Bundle? = null, isRoot: Boolean = false) {
    val intent = Intent(context, clazz)

    bundle?.let { intent.putExtras(it) }

    intent.run {
      addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

      if (isRoot) {
        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
      }
    }

    context.startActivity(intent)
  }


  fun toMain() = startActivity(MainActivity::class.java, isRoot = true)

  fun toDetail(entity: CityEntity?) {
    startActivity(DetailActivity::class.java, Bundle().apply {
      putParcelable(MainActivity.ENTITY_KEY, entity)
    })
  }
}