package com.sys1yagi.android.prpl.data.source.local

import com.sys1yagi.android.prpl.data.cachestore.CacheController
import com.sys1yagi.android.prpl.data.entity.Commits
import com.sys1yagi.android.prpl.data.entity.Repo
import com.sys1yagi.android.prpl.data.source.ReposDataSource
import com.sys1yagi.android.prpl.data.source.cachepolicy.ReposCachePolicy
import com.sys1yagi.android.prpl.extension.genericType

class ReposLocalDataSource(val cachePolicy: ReposCachePolicy, val cacheController: CacheController) : ReposDataSource {
    override fun repos(userName: String): List<Repo> {
        return cacheController.getList(cachePolicy.reposCacheKey(userName), genericType<List<Repo>>())
    }

    override fun repo(userName: String, repoName: String): Repo {
        return cacheController.get(cachePolicy.repoCacheKey(userName, repoName))
    }

    override fun commitList(owner: String, repoName: String): List<Commits> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
