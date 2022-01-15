package com.example.gomin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gomin.base.SingleLiveEvent
import com.example.gomin.dto.GominDetail
import com.example.gomin.dto.GominUpload
import com.example.gomin.repository.GominRepository

class GominUploadViewModel(private val gominRepository: GominRepository) : ViewModel() {

    val title = MutableLiveData<String>()
    val content = MutableLiveData<String>()

    private val _successedUpload = MutableLiveData(false)
    val successedUpload : LiveData<Boolean> = _successedUpload

    val successUpload = MutableLiveData<Boolean>(false)

    fun upload() {
        gominRepository.gominUpload(GominUpload(title.value!!, content.value!!)).subscribe { it->
            if (it.isSuccessful){

                //TODO
                //_successedUpload
            }
        }
    }
}