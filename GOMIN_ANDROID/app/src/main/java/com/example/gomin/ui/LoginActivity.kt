package com.example.gomin.ui

import com.example.gomin.R
import com.example.gomin.base.BaseActivity
import com.example.gomin.databinding.ActivityLoginBinding
import com.example.gomin.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    override val vm: LoginViewModel by viewModel()

    override fun observeEvent() {
        TODO("Not yet implemented")
    }

}