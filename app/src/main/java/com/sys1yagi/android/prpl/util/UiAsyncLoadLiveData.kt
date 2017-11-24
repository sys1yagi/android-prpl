package com.sys1yagi.android.prpl.util

import android.arch.lifecycle.MutableLiveData
import com.sys1yagi.android.prpl.extension.EMPTY_JOB
import com.sys1yagi.android.prpl.extension.ui


class UiAsyncLoadLiveData<T>(val active: suspend UiAsyncLoadLiveData<T>.() -> Unit) : MutableLiveData<T>() {
    var job = EMPTY_JOB

    override fun onActive() {
        job = ui {
            active()
        }
    }

    override fun onInactive() {
        job.cancel()
    }
}
