package com.example.gomin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gomin.BR
import com.example.gomin.R
import com.example.gomin.adapter.RecyclerViewItem
import com.example.gomin.base.SingleLiveEvent
import com.example.gomin.model.MyGominEntity
import com.example.gomin.repository.MyGominRepository

class MyGominsViewModel(private val myGominRepository: MyGominRepository): ViewModel() {

    private val _myGominItemViews = MutableLiveData<List<RecyclerViewItem>>()
    val myGominItemViews: LiveData<List<RecyclerViewItem>> = _myGominItemViews

    private val _showDetailGominId = SingleLiveEvent<String>()
    val showDetailGominId: LiveData<String> = _showDetailGominId

    init {
        getMyGomins()
    }

    private fun getMyGomins() {
        myGominRepository.getMyGomins().subscribe { response->
            if (response.isSuccessful) {
                _myGominItemViews.value = response.body()!!.map {
                    RecyclerViewItem(
                        R.layout.item_my_gomin,
                        MyGominItemViewModel(it),
                        BR.vm
                    )
                }
            }
        }
    }

    inner class MyGominItemViewModel(val data: MyGominEntity, private val viewModel: MyGominsViewModel = this@MyGominsViewModel) {
        fun showDetail() {
            viewModel._showDetailGominId.value = data.id
        }
    }
}