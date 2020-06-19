package com.takhir.weather.executor

import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class JobExecutor(
  threadNamePrefix: String = THREAD_NAME_PREFIX,
  corePoolSize: Int = CORE_POOL_SIZE,
  maxPoolSize: Int = MAX_POOL_SIZE,
  keepAliveTimeValue: Long = KEEP_ALIVE_TIME_VALUE,
  keepAliveTimeUnit: TimeUnit = KEEP_ALIVE_TIME_UNIT,
  killCoreThread: Boolean = KILL_CORE_THREAD
) : ThreadPoolExecutor(
  corePoolSize,
  maxPoolSize,
  keepAliveTimeValue,
  keepAliveTimeUnit,
  LinkedBlockingDeque<Runnable>(),
  JobThreadExecutor(threadNamePrefix)
) {

  companion object {
    private const val THREAD_NAME_PREFIX = "job_executor_"
    private const val CORE_POOL_SIZE = 5
    private const val MAX_POOL_SIZE = 10
    private const val KEEP_ALIVE_TIME_VALUE = 60L
    private val KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS
    private const val KILL_CORE_THREAD = true
  }

  init {
    if (keepAliveTimeValue > 0 && killCoreThread) {
      allowCoreThreadTimeOut(true)
    }
  }

  private class JobThreadExecutor(private val threadNamePrefix: String) : ThreadFactory {

    private var counter = 0

    private val threadName: String
      get() = "$threadNamePrefix${counter++}"

    override fun newThread(runnable: Runnable) = Thread(runnable, threadName)
  }
}