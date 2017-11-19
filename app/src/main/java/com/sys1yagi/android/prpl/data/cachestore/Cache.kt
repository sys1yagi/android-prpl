package com.sys1yagi.android.prpl.data.cachestore

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.ColumnInfo



@Entity(tableName = "cache")
class Cache {
    @PrimaryKey
    var id: Long = 0L

    @ColumnInfo(name = "key", index = true)
    var key: String = ""

    @ColumnInfo(name = "value")
    var value: String = ""
}
