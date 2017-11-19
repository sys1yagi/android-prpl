package com.sys1yagi.android.prpl.data.source

import com.sys1yagi.android.prpl.data.entity.User

interface UserDataSource {
    fun getUser(user: String): User
}
