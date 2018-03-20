package com.sys1yagi.android.prpl.data.source

import com.sys1yagi.android.prpl.data.entity.Commits
import com.sys1yagi.android.prpl.data.entity.Repo

interface ReposDataSource {
    fun repo(userName: String, repoName: String): Repo
    fun repos(userName: String): List<Repo>
    fun commitList(owner: String, repoName: String): List<Commits>
}
