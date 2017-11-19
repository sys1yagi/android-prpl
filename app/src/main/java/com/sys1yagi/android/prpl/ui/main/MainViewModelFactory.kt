package com.sys1yagi.android.prpl.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.sys1yagi.android.prpl.data.source.cachepolicy.ReposCachePolicy
import com.sys1yagi.android.prpl.data.source.factory.ReposDataSourceFactory

class MainViewModelFactory(val cachePolicy: ReposCachePolicy, val factory: ReposDataSourceFactory) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (MainViewModel::class.java.isAssignableFrom(modelClass)) {
            MainViewModel(cachePolicy, factory) as T
        } else {
            throw RuntimeException("Cannot create an instance of " + modelClass)
        }
    }
}
