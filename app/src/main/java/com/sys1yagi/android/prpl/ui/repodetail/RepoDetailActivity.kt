package com.sys1yagi.android.prpl.ui.repodetail

import activitystarter.Arg
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.marcinmoskala.activitystarter.argExtra
import com.sys1yagi.android.prpl.R
import com.sys1yagi.android.prpl.databinding.ActivityRepoDetailBinding

class RepoDetailActivity : AppCompatActivity() {
    @get:Arg
    val repoId: Long by argExtra()

    val binding: ActivityRepoDetailBinding by lazy { DataBindingUtil.setContentView<ActivityRepoDetailBinding>(this, R.layout.activity_repo_detail) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RepoDetailActivityStarter.fill(this)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Repo Detail"
        }
    }


}
