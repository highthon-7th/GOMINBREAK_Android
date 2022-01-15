package com.example.gomin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gomin.base.SingleLiveEvent
import com.example.gomin.repository.GominRepository

class GominUploadViewModel(private val gominRepository: GominRepository) : ViewModel() {

    val title = MutableLiveData<String>()
    val content = MutableLiveData<String>()

    val successUpload = SingleLiveEvent<Unit>()

    fun upload() {
        gominRepository.gominUpload(title.value!!, content.value!!).subscribe { response ->
            if (response.isSuccessful){

            }
        }
    }
}