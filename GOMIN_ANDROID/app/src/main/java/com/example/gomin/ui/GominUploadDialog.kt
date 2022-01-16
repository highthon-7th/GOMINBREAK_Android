package com.example.gomin.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.gomin.R
import com.example.gomin.base.BaseDialog
import com.example.gomin.databinding.DialogUploadGominBinding

class GominUploadDialog(override val vm: ViewModel) :
    BaseDialog<DialogUploadGominBinding>(R.layout.dialog_upload_gomin) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            imageView5.setOnClickListener {
                dismiss()
            }

            textView6.setOnClickListener {
                vm?.upload()
                if (vm?.successedUpload?.value == true) {
                    dismiss()
                } else {
                    dismiss()
                }
            }
        }
    }
}