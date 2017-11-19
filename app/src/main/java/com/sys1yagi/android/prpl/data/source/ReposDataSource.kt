package com.sys1yagi.android.prpl.data.source

import com.sys1yagi.android.prpl.data.entity.Repo

interface ReposDataSource {
    fun repos(user: String): List<Repo>
}
