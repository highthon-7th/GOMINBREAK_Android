package com.example.gomin.ui

import com.example.gomin.R
import com.example.gomin.base.BaseActivity
import com.example.gomin.databinding.ActivityMyGominsBinding
import com.example.gomin.viewmodel.MyGominsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyGominsActivity : BaseActivity<ActivityMyGominsBinding>(R.layout.activity_my_gomins) {
    override val vm: MyGominsViewModel by viewModel()

    override fun observeEvent() {
        binding.myGominTb.setNavigationOnClickListener {
            finish()
        }
        
    }
}