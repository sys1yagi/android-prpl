package com.sys1yagi.android.prpl.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.sys1yagi.android.prpl.R
import com.sys1yagi.android.prpl.databinding.ActivityMainBinding
import com.sys1yagi.android.prpl.extension.gone
import com.sys1yagi.android.prpl.extension.observe
import com.sys1yagi.android.prpl.extension.visible
import com.sys1yagi.android.prpl.ui.repodetail.RepoDetailActivityStarter
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.ViewHolder
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {

    val binding by lazy { DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main) }
    val factory: MainViewModelFactory by inject()
    val viewModel by lazy<MainContract.ViewModel> { ViewModelProviders.of(this, factory).get(MainViewModel::class.java) }
    val adapter = GroupAdapter<ViewHolder<ViewDataBinding>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Repositories"
        }
        binding.recyclerView.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        }
        adapter.setOnItemClickListener { item, view ->
            when (item) {
                is RepoNameItem -> {
                    RepoDetailActivityStarter.start(this, item.id)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.repositories.observe(this) {
            adapter.clear()
            it?.forEach {
                adapter.add(it)
            }
            adapter.notifyDataSetChanged()
        }

        viewModel.progress.observe(this) {
            if (it == true) {
                binding.progressBar.visible()
                binding.recyclerView.gone()
            } else {
                binding.progressBar.gone()
                binding.recyclerView.visible()
            }
        }

        viewModel.loadError.observe(this) {
            // TODO
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.repositories.removeObservers(this)
    }
}
