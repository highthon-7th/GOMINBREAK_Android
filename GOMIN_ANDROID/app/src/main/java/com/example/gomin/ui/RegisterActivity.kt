package com.example.gomin.ui

import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.gomin.R
import com.example.gomin.base.BaseActivity
import com.example.gomin.databinding.ActivityRegisterBinding
import com.example.gomin.viewmodel.RegisterViewModel
import com.google.android.material.snackbar.Snackbar
import com.jakewharton.rxbinding4.widget.textChanges
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.concurrent.TimeUnit

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(R.layout.activity_register) {
    override val vm: RegisterViewModel by viewModel()

    override fun observeEvent() {
        binding.run {
            registerBackBtn.setOnClickListener {
                finish()
            }
            registerBtn.setOnClickListener {
                vm?.register()
            }
        }
        vm.run {
            doneRegister.observe(this@RegisterActivity, {
                Snackbar.make(binding.root, "회원가입을 완료하였습니다", Snackbar.LENGTH_SHORT).show()
                finish()
            })

            checkPassword.observe(this@RegisterActivity, {
                binding.checkPasswordError.visibility =
                    if (isPasswordEntered() && isPasswordDifferent()) View.VISIBLE
                    else View.INVISIBLE
            })
        }
    }

    private fun isPasswordEntered(): Boolean =
        !vm.password.value.isNullOrEmpty() && !vm.checkPassword.value.isNullOrEmpty()

    private fun isPasswordDifferent(): Boolean =
        vm.password.value != vm.checkPassword.value
}