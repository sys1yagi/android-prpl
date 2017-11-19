package com.sys1yagi.android.prpl.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sys1yagi.android.prpl.R
import com.sys1yagi.android.prpl.databinding.ActivityMainBinding
import com.sys1yagi.android.prpl.extension.observe


class MainActivity : AppCompatActivity() {

    val binding by lazy { DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main) }
    //    val database by lazy { Room.databaseBuilder(applicationContext, CacheDatabase::class.java, "cache").build() }
    val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
    }

    override fun onResume() {
        super.onResume()
        viewModel.repositories.observe(this) {
            
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.repositories.removeObservers(this)
    }
}
