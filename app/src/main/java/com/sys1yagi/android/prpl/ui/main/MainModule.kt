package com.sys1yagi.android.prpl.ui.main

import com.sys1yagi.android.prpl.data.source.cachepolicy.ReposCachePolicy
import com.sys1yagi.android.prpl.data.source.factory.ReposDataSourceFactory
import org.koin.android.module.AndroidModule

class MainModule : AndroidModule() {
    override fun context() = applicationContext {
        context("Main") {
            provide<ReposCachePolicy> {
                ReposCachePolicy(get())
            }

            provide<ReposDataSourceFactory> {
                ReposDataSourceFactory(get(), get(), get())
            }

            provide<MainViewModelFactory>{
                MainViewModelFactory(get(), get())
            }
        }
    }
}
