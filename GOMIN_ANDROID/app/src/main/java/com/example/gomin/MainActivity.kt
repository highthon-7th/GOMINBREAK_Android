package com.example.gomin

import android.content.Intent
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.gomin.base.BaseActivity
import com.example.gomin.databinding.ActivityMainBinding
import com.example.gomin.ui.LoginActivity
import com.example.gomin.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override val vm: MainViewModel by viewModel()

    override fun observeEvent() {
        binding.mainBottomNv.setupWithNavController(
            Navigation.findNavController(
                this,
                R.id.main_container
            )
        )
        vm.startLogin.observe(this, {
            startLogin()
        })
    }

    private fun startLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}