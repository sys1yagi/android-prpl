package com.sys1yagi.android.prpl.data.source.cachepolicy

import com.sys1yagi.android.prpl.data.cachestore.CacheDao

class ReposCachePolicy(private val cacheDao: CacheDao) {
    fun hasCache(userName: String): Boolean {
        return false
    }
}
