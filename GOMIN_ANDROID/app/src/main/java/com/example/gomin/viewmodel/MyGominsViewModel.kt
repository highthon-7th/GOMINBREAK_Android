package com.example.gomin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gomin.adapter.RecyclerViewItem
import com.example.gomin.repository.MyGominRepository

class MyGominsViewModel(private val myGominRepository: MyGominRepository): ViewModel() {

    private val _myGominItemViews = MutableLiveData<List<RecyclerViewItem>>()
    val myGominItemViews: LiveData<List<RecyclerViewItem>> = _myGominItemViews

    fun getMyGomins() {
        myGominRepository.getMyGomins().subscribe { response->
            if (response.isSuccessful) {
                _myGominItemViews.value = response.body()!!.map {
                    RecyclerViewItem(
                        
                    )
                }
            }
        }
    }
}