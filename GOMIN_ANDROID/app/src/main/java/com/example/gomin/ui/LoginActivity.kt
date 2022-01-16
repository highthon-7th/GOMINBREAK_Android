package com.example.gomin.ui

import android.content.Intent
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.gomin.R
import com.example.gomin.base.BaseActivity
import com.example.gomin.databinding.ActivityLoginBinding
import com.example.gomin.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    override val vm: LoginViewModel by viewModel()

    override fun observeEvent() {
        binding.loginBtn.setOnClickListener {
            finish()
        }

        binding.startRegisterBtn.setOnClickListener {
            val registerIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registerIntent)
        }

        setBackPress()
    }

    private var lastTimeBackPressed: Long = -1500

    fun setBackPress() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (System.currentTimeMillis() - lastTimeBackPressed <= 1500) {
                    moveTaskToBack(true)
                    finish()
                    android.os.Process.killProcess(android.os.Process.myPid())
                }
                lastTimeBackPressed = System.currentTimeMillis()
                Toast.makeText(this@LoginActivity, "뒤로가기 버튼을 한 번 더 누르면 종료됩니다", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)
    }

}