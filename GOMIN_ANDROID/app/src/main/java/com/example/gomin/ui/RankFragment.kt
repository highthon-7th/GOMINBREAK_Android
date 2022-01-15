package com.example.gomin.ui

import com.example.gomin.R
import com.example.gomin.base.BaseFragment
import com.example.gomin.databinding.FragmentRankBinding
import com.example.gomin.viewmodel.RankViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RankFragment : BaseFragment<FragmentRankBinding>(R.layout.fragment_rank) {

    override val vm: RankViewModel by viewModel()

    override fun observeEvent() {

    }
}