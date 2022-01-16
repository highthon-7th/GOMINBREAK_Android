package com.example.gomin.ui

import androidx.recyclerview.widget.GridLayoutManager
import com.example.gomin.R
import com.example.gomin.adapter.GominAdapter
import com.example.gomin.base.BaseFragment
import com.example.gomin.databinding.FragmentGominBinding
import com.example.gomin.viewmodel.GominViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GominFragment : BaseFragment<FragmentGominBinding>(R.layout.fragment_gomin) {
    override val vm: GominViewModel by viewModel()
    private val RVAdapter by lazy { GominAdapter(vm) }

    private val GominWriteDialog by lazy {
        GominUploadDialog(vm)
    }

    private fun GominWriteDialog() {
        GominWriteDialog.show(
            requireActivity().supportFragmentManager,
            "finishDialog"
        )
    }

    private fun showRV() {
        binding.recyclerview.adapter = RVAdapter
        val myLayoutManager = GridLayoutManager(context, 3)
        binding.recyclerview.layoutManager = myLayoutManager
    }


    override fun observeEvent() {
        vm.run {
            binding.floatingBtn.setOnClickListener {
                GominWriteDialog()
            }
            showRV()
            getGominList()

        }

    }
}