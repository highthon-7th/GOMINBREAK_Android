package com.example.gomin.ui.rank

import com.example.gomin.R
import com.example.gomin.base.BaseFragment
import com.example.gomin.databinding.FragmentStudentBinding
import com.example.gomin.viewmodel.RankViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class StudentFragment : BaseFragment<FragmentStudentBinding>(R.layout.fragment_student) {
    override val vm: RankViewModel by sharedViewModel()

    override fun observeEvent() {
        
    }
}