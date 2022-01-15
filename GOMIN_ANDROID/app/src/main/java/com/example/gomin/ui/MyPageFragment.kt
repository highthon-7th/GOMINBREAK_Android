package com.example.gomin.ui

import com.example.gomin.R
import com.example.gomin.base.BaseFragment
import com.example.gomin.databinding.FragmentMypageBinding
import com.example.gomin.viewmodel.MyPageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyPageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    override val vm: MyPageViewModel by viewModel()

    override fun observeEvent() {

    }

}