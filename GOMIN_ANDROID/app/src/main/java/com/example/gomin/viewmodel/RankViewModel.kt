package com.example.gomin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gomin.adapter.RecyclerViewItem

class RankViewModel: ViewModel() {

    private val _schoolRank = MutableLiveData<List<RecyclerViewItem>>()
    val schoolRank: LiveData<List<RecyclerViewItem>> = _schoolRank

    private val _studentRank = MutableLiveData<List<RecyclerViewItem>>()
    val studentRank: LiveData<List<RecyclerViewItem>> = _studentRank
}