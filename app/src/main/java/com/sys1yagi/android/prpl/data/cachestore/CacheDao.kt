package com.sys1yagi.android.prpl.data.cachestore

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface CacheDao {

    @Query("SELECT * FROM cache WHERE key = :key LIMIT 1")
    fun get(key: String): Cache

    @Insert
    fun insert(cache: Cache)

    @Delete
    fun delete(cache: Cache)
}
