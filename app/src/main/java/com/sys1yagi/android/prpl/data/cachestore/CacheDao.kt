package com.sys1yagi.android.prpl.data.cachestore

import android.arch.persistence.room.*

@Dao
interface CacheDao {

    @Query("SELECT * FROM cache WHERE key = :key LIMIT 1")
    fun get(key: String): Cache

    @Query("SELECT count(0) FROM cache WHERE key = :key LIMIT 1")
    fun exists(key: String): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cache: Cache)

    @Delete
    fun delete(cache: Cache)
}
