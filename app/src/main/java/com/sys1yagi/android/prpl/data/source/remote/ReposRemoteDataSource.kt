package com.sys1yagi.android.prpl.data.source.remote

import com.sys1yagi.android.prpl.data.cachestore.CacheController
import com.sys1yagi.android.prpl.data.entity.Repo
import com.sys1yagi.android.prpl.data.retrofit.ApiClient
import com.sys1yagi.android.prpl.data.source.ReposDataSource
import com.sys1yagi.android.prpl.data.source.cachepolicy.ReposCachePolicy
import com.sys1yagi.android.prpl.data.source.exception.ErrorResponseException

class ReposRemoteDataSource(private val apiClient: ApiClient, private val cachePolicy: ReposCachePolicy, private val cacheController: CacheController) : ReposDataSource {
    override fun repos(userName: String): List<Repo> {
        val result = apiClient.listRepos(userName).execute()
        if (result.isSuccessful) {
            return result.body()?.also {
                cacheController.put(cachePolicy.reposCacheKey(userName), it)
            } ?: throw Exception("body not found.")
        } else {
            throw ErrorResponseException(result)
        }
    }
}
