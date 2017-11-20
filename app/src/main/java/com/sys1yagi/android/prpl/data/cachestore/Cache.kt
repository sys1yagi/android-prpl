package com.sys1yagi.android.prpl.data.cachestore

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "cache")
class Cache {
    @PrimaryKey
    var id: Long = 0L

    @ColumnInfo(name = "key", index = true)
    var key: String = ""

    @ColumnInfo(name = "value")
    var value: String = ""

    @ColumnInfo(name = "created_at")
    var createdAt: Long = 0L
}
