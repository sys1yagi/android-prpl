package com.sys1yagi.android.prpl.data.cachestore

import com.google.gson.Gson
import com.sys1yagi.android.prpl.util.TimeProvider
import java.lang.reflect.Type

class CacheController(val cacheDao: CacheDao, val gson: Gson, val timeProvider: TimeProvider) {
    fun <T> put(key: String, value: T) {
        cacheDao.insert(Cache().apply {
            this.key = key
            this.value = gson.toJson(value)
            this.createdAt = timeProvider.now()
        })
    }

    inline fun <reified T> get(key: String): T? {
        return cacheDao.get(key)?.let {
            gson.fromJson(it.value, T::class.java)
        }
    }

    inline fun <reified T> getList(key: String, type: Type): List<T>? {
        return cacheDao.get(key)?.let {
            gson.fromJson(it.value, type)
        }
    }

    fun hasKey(key: String): Boolean {
        return cacheDao.exists(key)
    }
}
