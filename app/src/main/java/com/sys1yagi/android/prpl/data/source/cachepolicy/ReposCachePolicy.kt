package com.sys1yagi.android.prpl.data.source.cachepolicy

import com.sys1yagi.android.prpl.data.cachestore.CacheDao

class ReposCachePolicy(private val cacheDao: CacheDao) {

    fun reposCacheKey(userName: String) = "repos-$userName"

    fun hasCache(userName: String): Boolean {
        return cacheDao.exists(reposCacheKey(userName))
    }
}
