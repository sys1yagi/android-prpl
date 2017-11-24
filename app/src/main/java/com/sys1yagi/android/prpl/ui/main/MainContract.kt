package com.sys1yagi.android.prpl.ui.main

import android.arch.lifecycle.LiveData

interface MainContract {
    interface ViewModel {
        val repositories: LiveData<List<RepoNameItem>>
        val progress: LiveData<Boolean>
        val loadError: LiveData<Exception>
    }
}
