package com.sys1yagi.android.prpl.data.source.factory

import com.sys1yagi.android.prpl.data.source.UserDataSource
import com.sys1yagi.android.prpl.data.source.cachepolicy.UserCachePolicy
import com.sys1yagi.android.prpl.data.source.local.UserLocalDataSource
import com.sys1yagi.android.prpl.data.source.remote.UserRemoteDataSource

class UserDataSourceFactory(private val policy: UserCachePolicy) {
    fun get(userName: String): UserDataSource {
        if (policy.hasCache(userName)) {
            return UserLocalDataSource()
        } else {
            return UserRemoteDataSource()
        }
    }
}
