package com.example.gomin.ui

import com.example.gomin.R
import com.example.gomin.base.BaseActivity
import com.example.gomin.databinding.ActivityRegisterBinding
import com.example.gomin.viewmodel.RegisterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(R.layout.activity_register) {
    override val vm: RegisterViewModel by viewModel()

    override fun observeEvent() {
        TODO("Not yet implemented")
    }
}