package com.example.gomin.ui

import androidx.lifecycle.ViewModel
import com.example.gomin.R
import com.example.gomin.base.BaseFragment
import com.example.gomin.databinding.FragmentGominBinding
import com.example.gomin.viewmodel.GominViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GominFragment(override val vm: ViewModel) : BaseFragment<FragmentGominBinding>(R.layout.fragment_gomin) {
    override fun observeEvent() {
        TODO("Not yet implemented")
    }

//    override val vm : GominViewModel by viewModel()
//
//    private val GominWriteDialog by lazy {
//        GominUploadDialog(vm)
//    }
//
//    private fun GominWriteDialog() {
//        GominWriteDialog.show(
//            requireActivity().supportFragmentManager,
//            "finishDialog"
//        )
//    }
//
//    override fun observeEvent() {
//        vm.run {
//            binding.floatingBtn.setOnClickListener {
//                GominWriteDialog()
//            }
//        }
//
//    }
}