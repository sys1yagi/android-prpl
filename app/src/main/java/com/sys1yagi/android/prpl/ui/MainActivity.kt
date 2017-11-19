package com.sys1yagi.android.prpl.ui

import android.arch.persistence.room.Room
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sys1yagi.android.prpl.R
import com.sys1yagi.android.prpl.data.cachestore.CacheDatabase
import com.sys1yagi.android.prpl.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val binding by lazy { DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main) }
    val database by lazy { Room.databaseBuilder(applicationContext, CacheDatabase::class.java, "cache").build() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.insert.setOnClickListener {

        }
        binding.delete.setOnClickListener {

        }

    }
}
