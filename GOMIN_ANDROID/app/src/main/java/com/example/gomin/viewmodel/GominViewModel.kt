package com.example.gomin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gomin.dto.GominDetail
import com.example.gomin.repository.GominRepository

class GominViewModel(private val gominRepository: GominRepository) : ViewModel() {

    private val _gominDetailContent = MutableLiveData<GominDetail>()
    val gominDetailContent :  LiveData<GominDetail> get() =  _gominDetailContent

    var gominListSize : String = ""

    private val _clickedGominId = MutableLiveData<String>()
    val clickedGominId : LiveData<String> get() = _clickedGominId

    fun onClubClicked(gomin :String){
        _clickedGominId.value = gomin
    }

    private val _gominListObject = MutableLiveData<List<String>>()
    val gominListObject :  LiveData<List<String>> get() = _gominListObject

    fun getGominList() {
        gominRepository.showGominList().subscribe { it ->
            if (it.isSuccessful) {
                _gominListObject.value = listOf(it.body().toString())
                //recycler view에 이 List Size 맞춰서
                gominListSize = _gominListObject.value!!.size.toString()
            }
        }
    }

    fun getGominDetail(gomin :String) {
        gominRepository.showGominListDetail(gomin).subscribe { it ->
            if (it.isSuccessful) {
                _gominDetailContent.value = it.body()
            }
            else{
                //TODO 데이터 로드에 실패함
            }
        }
    }

}