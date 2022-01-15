package com.example.gomin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.example.gomin.base.BaseActivity
import com.example.gomin.databinding.ActivityMainBinding
import com.example.gomin.ui.LoginActivity
import com.example.gomin.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override val vm: MainViewModel by viewModel()

    override fun observeEvent() {
        vm.startLogin.observe(this, {
            startLogin()
        })
    }

    private fun startLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}