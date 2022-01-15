package com.example.gomin.ui

import com.example.gomin.R
import com.example.gomin.base.BaseActivity
import com.example.gomin.databinding.ActivityEditMyinfoBinding
import com.example.gomin.viewmodel.EditInfoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditInfoActivity : BaseActivity<ActivityEditMyinfoBinding>(R.layout.activity_edit_myinfo) {
    override val vm: EditInfoViewModel by viewModel()

    override fun observeEvent() {
        binding.editTb.setNavigationOnClickListener {
            finish()
        }
    }
}