package com.sys1yagi.android.prpl.data.retrofit

import com.sys1yagi.android.prpl.data.entity.Commits
import com.sys1yagi.android.prpl.data.entity.Repo
import com.sys1yagi.android.prpl.data.entity.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiClient {
    @GET("users/{username}")
    fun getUser(@Path("username") userName: String): Call<User>

    @GET("users/{username}/repos")
    fun repoList(@Path("username") userName: String): Call<List<Repo>>

    @GET("repos/{username}/{repo_name}")
    fun repo(@Path("username") userName: String, @Path("repo_name") repoName: String): Call<Repo>

    @GET("repos/{owner}/{repo_name}/commits")
    fun commitList(@Path("owner") owner: String, @Path("repo_name") repoName: String): Call<List<Commits>>
}
