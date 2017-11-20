package com.sys1yagi.android.prpl.di

import android.arch.persistence.room.Room
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sys1yagi.android.prpl.data.cachestore.CacheController
import com.sys1yagi.android.prpl.data.cachestore.CacheDao
import com.sys1yagi.android.prpl.data.cachestore.CacheDatabase
import com.sys1yagi.android.prpl.data.retrofit.ApiClient
import okhttp3.OkHttpClient
import org.koin.android.module.AndroidModule
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DataModule(val applicationContext: Context) : AndroidModule() {
    override fun context() = applicationContext {
        provide<OkHttpClient> {
            OkHttpClient.Builder().build()
        }

        provide<Retrofit> {
            Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        provide<ApiClient> {
            get<Retrofit>().create(ApiClient::class.java)
        }

        provide<CacheDatabase> {
            Room.databaseBuilder(applicationContext, CacheDatabase::class.java, "cache").build()
        }

        provide<CacheDao> {
            get<CacheDatabase>().cacheDao()
        }

        provide<CacheController> {
            CacheController(get(), get(), get())
        }

        provide<Gson> {
            GsonBuilder().create()
        }
    }
}
