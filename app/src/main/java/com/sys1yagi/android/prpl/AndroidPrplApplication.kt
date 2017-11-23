package com.sys1yagi.android.prpl

import android.app.Application
import com.sys1yagi.android.prpl.di.AppModule
import com.sys1yagi.android.prpl.di.DataModule
import com.sys1yagi.android.prpl.di.OkHttpModule
import com.sys1yagi.android.prpl.ui.main.MainModule
import com.sys1yagi.android.prpl.util.StethoInitializer
import org.koin.android.ext.android.startAndroidContext

class AndroidPrplApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startAndroidContext(
                this,
                AppModule(),
                OkHttpModule(),
                DataModule(this),
                MainModule()
        )
        StethoInitializer.start(this)
    }
}
