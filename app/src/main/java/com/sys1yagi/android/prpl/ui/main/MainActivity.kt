package com.sys1yagi.android.prpl.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.sys1yagi.android.prpl.R
import com.sys1yagi.android.prpl.databinding.ActivityMainBinding
import com.sys1yagi.android.prpl.extension.observe
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {

    val binding by lazy { DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main) }
    val factory: MainViewModelFactory by inject()
    val viewModel by lazy { ViewModelProviders.of(this, factory).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
    }

    override fun onResume() {
        super.onResume()
        viewModel.repositories.observe(this) {
            it?.forEach{
                Log.d("data", it.name)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.repositories.removeObservers(this)
    }
}
