package com.sys1yagi.android.prpl.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.sys1yagi.android.prpl.data.entity.Repo
import com.sys1yagi.android.prpl.extension.EMPTY_JOB
import com.sys1yagi.android.prpl.extension.ui
import java.util.concurrent.CancellationException

class MainViewModel : ViewModel() {
    var repositories: LiveData<List<Repo>> = object : MutableLiveData<List<Repo>>() {
        var job = EMPTY_JOB

        override fun onActive() {
            job = ui {
                try {
                    // TODO
                } catch (e: CancellationException) {
                    // handle cancel
                } catch (e: Exception) {
                    // handle error
                }
            }
        }

        override fun onInactive() {
            job.cancel()
        }
    }

    // Todo error LiveData
}
