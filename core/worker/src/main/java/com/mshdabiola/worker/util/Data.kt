package com.mshdabiola.worker.util

import androidx.work.CoroutineWorker
import androidx.work.Data
import kotlin.reflect.KClass

internal const val WORKER_CLASS_NAME = "RouterWorkerDelegateClassName"
internal const val ID = "id"
internal fun KClass<out CoroutineWorker>.delegatedData(id: Long) =
    Data.Builder()
        .putString(WORKER_CLASS_NAME, qualifiedName)
        .putLong(ID, id)
        .build()