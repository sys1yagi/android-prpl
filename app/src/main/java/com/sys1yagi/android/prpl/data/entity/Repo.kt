package com.sys1yagi.android.prpl.data.entity

import com.google.gson.annotations.SerializedName

data class Repo(
        val id: String? = null,
        val name: String? = null,
        @SerializedName("full_name")
        val fullName: String? = null,
        val owner: User? = null,
        val url: String? = null,
        val description: String? = null
)
