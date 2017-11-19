package com.sys1yagi.android.prpl.data.source.factory

import com.sys1yagi.android.prpl.data.cachestore.CacheController
import com.sys1yagi.android.prpl.data.cachestore.CacheDao
import com.sys1yagi.android.prpl.data.retrofit.ApiClient
import com.sys1yagi.android.prpl.data.source.ReposDataSource
import com.sys1yagi.android.prpl.data.source.cachepolicy.ReposCachePolicy
import com.sys1yagi.android.prpl.data.source.local.ReposLocalDataSource
import com.sys1yagi.android.prpl.data.source.remote.ReposRemoteDataSource

class ReposDataSourceFactory(private val policy: ReposCachePolicy, val apiClient: ApiClient, val cacheController: CacheController) {
    fun get(userName: String): ReposDataSource {
        if (policy.hasCache(userName)) {
            return ReposLocalDataSource(policy, cacheController)
        } else {
            return ReposRemoteDataSource(apiClient, policy, cacheController)
        }
    }
}
