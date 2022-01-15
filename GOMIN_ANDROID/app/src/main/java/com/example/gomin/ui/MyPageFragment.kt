package com.example.gomin.ui

import android.content.Intent
import com.example.gomin.R
import com.example.gomin.base.BaseFragment
import com.example.gomin.databinding.FragmentMypageBinding
import com.example.gomin.viewmodel.MyPageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyPageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    override val vm: MyPageViewModel by viewModel()

    override fun observeEvent() {
        binding.gominCountCl.setOnClickListener {
            startMyGomins()
        }
    }

    private fun startMyGomins() {
        val intent = Intent(requireContext(), MyGominsActivity::class.java)
        startActivity(intent)
    }

}