package com.sys1yagi.android.prpl.data.entity

import com.google.gson.annotations.SerializedName

/**
 * https://developer.github.com/v3/users/
 */
data class User(
        val login: String = "",
        val id: Long = 0,
        @SerializedName("avatar_url")
        val avatarUrl: String? = null,
        val name: String? = null,
        val company: String? = null,
        val email: String? = null,
        val bio: String? = null,
        @SerializedName("public_repos")
        val publicRepos: Int = 0,
        @SerializedName("public_gists")
        val publicGists: Int = 0,
        val followers: Int = 0,
        val following: Int = 0,
        @SerializedName("created_at")
        val createdAt: String = "",
        @SerializedName("updated_url")
        val updatedAt: String = ""
)
