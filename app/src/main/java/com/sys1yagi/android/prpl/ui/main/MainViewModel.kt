package com.sys1yagi.android.prpl.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.sys1yagi.android.prpl.data.source.cachepolicy.ReposCachePolicy
import com.sys1yagi.android.prpl.data.source.factory.ReposDataSourceFactory
import com.sys1yagi.android.prpl.extension.async
import com.sys1yagi.android.prpl.util.UiAsyncLoadLiveData
import java.util.concurrent.CancellationException

class MainViewModel(private val cachePolicy: ReposCachePolicy, private val factory: ReposDataSourceFactory) : ViewModel(), MainContract.ViewModel {
    override val repositories: LiveData<List<RepoNameItem>> = UiAsyncLoadLiveData {
        try {
            progress.value = true
            value = async {
                factory
                        .get("sys1yagi")
                        .repos("sys1yagi")
                        .map {
                            RepoNameItem(it)
                        }
            }.await()
        } catch (e: CancellationException) {
            // handle cancel
        } catch (e: Exception) {
            loadError.value = e
        } finally {
            progress.value = false
        }
    }

    override val progress = MutableLiveData<Boolean>()

    override val loadError = MutableLiveData<Exception>()
}
