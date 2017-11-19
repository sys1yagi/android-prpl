package com.sys1yagi.android.prpl.data.source.factory

import com.sys1yagi.android.prpl.data.source.ReposDataSource
import com.sys1yagi.android.prpl.data.source.cachepolicy.ReposCachePolicy
import com.sys1yagi.android.prpl.data.source.local.ReposLocalDataSource
import com.sys1yagi.android.prpl.data.source.remote.ReposRemoteDataSource

class ReposDataSourceFactory(private val policy: ReposCachePolicy) {
    fun get(userName: String): ReposDataSource {
        if (policy.hasCache(userName)) {
            return ReposLocalDataSource()
        } else {
            return ReposRemoteDataSource()
        }
    }
}
