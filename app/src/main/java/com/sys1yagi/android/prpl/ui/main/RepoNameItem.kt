package com.sys1yagi.android.prpl.ui.main

import com.sys1yagi.android.prpl.R
import com.sys1yagi.android.prpl.data.entity.Repo
import com.sys1yagi.android.prpl.databinding.ListitemRepoNameBinding
import com.xwray.groupie.databinding.BindableItem

class RepoNameItem(val repo: Repo) : BindableItem<ListitemRepoNameBinding>() {
    override fun bind(binding: ListitemRepoNameBinding, position: Int) {
        binding.name.text = repo.name
        binding.description.text = repo.description
        binding.url.text = repo.url
    }

    override fun getLayout() = R.layout.listitem_repo_name
}
