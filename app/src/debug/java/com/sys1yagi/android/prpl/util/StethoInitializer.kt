package com.sys1yagi.android.prpl.util

import android.content.Context
import com.facebook.stetho.Stetho

object StethoInitializer {
    fun start(context: Context) {
        Stetho.initialize(
                Stetho.newInitializerBuilder(context)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(context))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(context))
                        .build()
        )
    }
}
