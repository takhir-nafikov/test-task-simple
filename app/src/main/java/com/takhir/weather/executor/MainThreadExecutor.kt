package com.takhir.weather.executor

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor

class MainThreadExecutor : Executor {

  private val handler = Handler(Looper.getMainLooper())

  override fun execute(command: Runnable) {
    handler.post(command)
  }
}