package com.example.gomin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gomin.R
import com.example.gomin.base.BaseActivity

class MyGominsActivity : BaseActivity<>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_gomins)
    }
}