package com.sys1yagi.android.prpl.data.source.cachepolicy

import com.sys1yagi.android.prpl.data.cachestore.CacheDao

class ReposCachePolicy(private val cacheDao: CacheDao) {

    fun reposCacheKey(userName: String) = "repos-$userName"

    fun hasReposCache(userName: String) = cacheDao.exists(reposCacheKey(userName))

    fun repoCacheKey(userName: String, repoName: String) = "repo-$userName-$repoName"

    fun hasRepoCache(userName: String, repoName: String) = cacheDao.exists(repoCacheKey(userName, repoName))

    fun repoCommitsCacheKey(owner: String, repoName: String) = "repo-commits-$owner-$repoName"

    fun hasRepoCommitsCache(owner: String, repoName: String) =  cacheDao.exists(repoCacheKey(owner, repoName))
}
