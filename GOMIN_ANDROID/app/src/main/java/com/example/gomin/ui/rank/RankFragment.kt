package com.example.gomin.ui.rank

import com.example.gomin.R
import com.example.gomin.base.BaseFragment
import com.example.gomin.databinding.FragmentRankBinding
import com.example.gomin.viewmodel.RankViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class RankFragment : BaseFragment<FragmentRankBinding>(R.layout.fragment_rank) {

    override val vm: RankViewModel by viewModel()

    companion object {
        private val titleList = arrayListOf("학생 순위", "학교 순위")
    }

    override fun observeEvent() {
        binding.rankVp.run {
            adapter = RankAdapter(requireActivity())
        }
        TabLayoutMediator(binding.rankTl, binding.rankVp) { tab, position ->
            binding.rankVp.currentItem = binding.rankTl.selectedTabPosition
            tab.text = titleList[position]
        }.attach()
    }
}