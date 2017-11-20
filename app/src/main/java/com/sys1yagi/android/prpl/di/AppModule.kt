package com.sys1yagi.android.prpl.di

import com.sys1yagi.android.prpl.util.DefaultTimeProvider
import com.sys1yagi.android.prpl.util.TimeProvider
import org.koin.android.module.AndroidModule

class AppModule : AndroidModule() {
    override fun context() = applicationContext {
        provide<TimeProvider> {
            DefaultTimeProvider()
        }
    }
}
