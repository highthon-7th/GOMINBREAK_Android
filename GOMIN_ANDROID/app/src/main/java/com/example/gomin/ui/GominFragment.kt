package com.example.gomin.ui

import android.widget.GridLayout
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.gomin.R
import com.example.gomin.adapter.GominAdapter
import com.example.gomin.base.BaseFragment
import com.example.gomin.databinding.FragmentGominBinding
import com.example.gomin.viewmodel.GominViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class GominFragment(override val vm: GominViewModel) : BaseFragment<FragmentGominBinding>(R.layout.fragment_gomin) {

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