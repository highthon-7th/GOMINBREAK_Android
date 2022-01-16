package com.example.gomin.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.gomin.R
import com.example.gomin.base.BaseDialog
import com.example.gomin.databinding.DialogShowGominBinding
import com.example.gomin.databinding.DialogUploadGominBinding
import com.example.gomin.viewmodel.GominViewModel

class GominShowDialog (override val vm: GominViewModel) :
    BaseDialog<DialogShowGominBinding>(R.layout.dialog_show_gomin) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
           imageView3.setOnClickListener {
               dismiss()
           }

        }
    }
}