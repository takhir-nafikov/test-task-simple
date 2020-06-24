package com.takhir.weather.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

  private val disposables = CompositeDisposable()

  fun addDisposable(vararg ds: Disposable) = disposables.addAll(*ds)

  override fun onCleared() {
    disposables.clear()

    super.onCleared()
  }
}