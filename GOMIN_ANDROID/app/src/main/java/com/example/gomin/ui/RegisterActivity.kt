package com.example.gomin.ui

import android.view.View
import com.example.gomin.R
import com.example.gomin.base.BaseActivity
import com.example.gomin.databinding.ActivityRegisterBinding
import com.example.gomin.viewmodel.RegisterViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

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
            vm?.doneRegister?.observe(this@RegisterActivity, {
                Snackbar.make(binding.root, "회원가입을 완료하였습니다", Snackbar.LENGTH_SHORT).show()
                finish()
            })
            vm?.checkPassword?.observe(this@RegisterActivity, {
                binding.checkPasswordError.visibility =
                    if (
                        !vm?.password?.value.isNullOrEmpty()
                        && vm?.password?.value == it
                        && !it.isNullOrEmpty()
                    ) View.INVISIBLE
                    else View.VISIBLE
            })
        }
    }
}