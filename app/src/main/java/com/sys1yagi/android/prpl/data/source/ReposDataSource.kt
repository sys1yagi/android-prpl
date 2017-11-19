package com.sys1yagi.android.prpl.data.source

import com.sys1yagi.android.prpl.data.entity.Repo

interface ReposDataSource {
    fun repos(userName: String): List<Repo>
}
