package com.example.gomin.ui

import android.content.Intent
import com.example.gomin.R
import com.example.gomin.base.BaseActivity
import com.example.gomin.databinding.ActivityLoginBinding
import com.example.gomin.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    override val vm: LoginViewModel by viewModel()

    override fun observeEvent() {
        binding.loginBtn.setOnClickListener {
            vm.login()
        }
        
        binding.startRegisterBtn.setOnClickListener {
            val registerIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registerIntent)
        }
    }

}