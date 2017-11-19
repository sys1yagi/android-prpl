package com.sys1yagi.android.prpl

import android.app.Application
import com.sys1yagi.android.prpl.di.DataModule
import com.sys1yagi.android.prpl.ui.main.MainModule
import org.koin.android.ext.android.startAndroidContext

class AndroidPrplApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startAndroidContext(
                this,
                DataModule(this),
                MainModule()
        )
    }
}
