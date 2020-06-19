package com.takhir.weather.repository

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executor

abstract class BaseRepository(
  private val jobExecutor: Executor
) {
  protected fun <T> buildObservable(source: (ObservableEmitter<T>) -> Unit) =
    Observable.create<T>(source)
      .subscribeOn(Schedulers.from(jobExecutor))
      .observeOn(AndroidSchedulers.mainThread())

  protected fun <T> buildSingle(source: (emitter: SingleEmitter<T>) -> Unit) =
    Single.create<T>(source)
      .subscribeOn(Schedulers.from(jobExecutor))
      .observeOn(AndroidSchedulers.mainThread())

  protected fun buildCompletable(source: (emitter: CompletableEmitter) -> Unit) =
    Completable.create(source)
      .subscribeOn(Schedulers.from(jobExecutor))
      .observeOn(AndroidSchedulers.mainThread())
}