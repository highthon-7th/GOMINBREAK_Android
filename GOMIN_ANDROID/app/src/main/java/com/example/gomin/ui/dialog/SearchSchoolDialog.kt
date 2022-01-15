package com.example.gomin.ui.dialog

import android.widget.TextView
import com.example.gomin.R
import com.example.gomin.base.BaseDialog
import com.example.gomin.databinding.DialogSearchSchoolBinding
import com.example.gomin.viewmodel.RegisterViewModel
import com.jakewharton.rxbinding4.widget.textChanges
import java.util.concurrent.TimeUnit

class SearchSchoolDialog(override val vm: RegisterViewModel) :
    BaseDialog<DialogSearchSchoolBinding>(R.layout.dialog_search_school) {

    override fun observeEvent() {
        binding.run {
            searchSchoolCancel.setOnClickListener {
                dismiss()
            }
            searchSchoolEt.observeInputText {
                vm.searchSchool(it)
            }
        }
    }

    private fun TextView.observeInputText(doOnInput: (name: String) -> Unit) {
        this.textChanges().debounce(500, TimeUnit.MILLISECONDS).subscribe {
            doOnInput(it.toString())
        }
    }
}