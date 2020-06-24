package com.takhir.weather.view.binding

import android.view.View
import androidx.databinding.BindingAdapter

object ViewBinding {
  @JvmStatic
  @BindingAdapter(value =["visibleOrGone"])
  fun bindVisibleOrGone(view: View, isVisible: Boolean?) {
    if (isVisible == true) {
      view.visibility = View.VISIBLE
    } else {
      view.visibility = View.GONE
    }
  }
}