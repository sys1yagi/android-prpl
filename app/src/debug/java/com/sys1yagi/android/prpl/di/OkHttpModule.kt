package com.sys1yagi.android.prpl.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import org.koin.android.module.AndroidModule

class OkHttpModule : AndroidModule() {
    override fun context() = applicationContext {
        provide<OkHttpClient> {
            OkHttpClient
                    .Builder()
                    .addNetworkInterceptor(StethoInterceptor())
                    .build()
        }
    }
}
