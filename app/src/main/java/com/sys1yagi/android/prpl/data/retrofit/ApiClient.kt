package com.sys1yagi.android.prpl.data.retrofit

import com.sys1yagi.android.prpl.data.entity.Commits
import com.sys1yagi.android.prpl.data.entity.Repo
import com.sys1yagi.android.prpl.data.entity.User
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiClient {
    @GET("users/{username}")
    fun getUser(@Path("username") user: String): User

    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): List<Repo>

    @GET("repos/{owner}/{repos}/commits")
    fun listCommit(@Path("owner") owner: String, @Path("repos") repos: String): List<Commits>
}
