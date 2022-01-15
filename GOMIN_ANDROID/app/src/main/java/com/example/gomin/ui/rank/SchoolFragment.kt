package com.example.gomin.ui.rank

import com.example.gomin.R
import com.example.gomin.base.BaseFragment
import com.example.gomin.databinding.FragmentSchoolBinding
import com.example.gomin.viewmodel.RankViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class SchoolFragment : BaseFragment<FragmentSchoolBinding>(R.layout.fragment_school) {
    override val vm: RankViewModel by sharedViewModel()

    override fun observeEvent() {

    }

}