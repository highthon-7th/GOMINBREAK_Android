package com.example.gomin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gomin.base.SingleLiveEvent
import com.example.gomin.model.RegisterEntity
import com.example.gomin.model.SchoolEntity
import com.example.gomin.repository.LoginRepository

class RegisterViewModel(private val repository: LoginRepository): ViewModel() {
    val userId = MutableLiveData<String>()

    val userName = MutableLiveData<String>()

    val password = MutableLiveData<String>()

    val checkPassword = MutableLiveData<String>()

    private val _selectedSchoolName = SingleLiveEvent<String>()
    val selectedSchoolName: LiveData<String> = _selectedSchoolName

    val doneRegister = SingleLiveEvent<Unit>()

    private val _searchSchoolRecyclerItems = MutableLiveData<List<SearchSchoolItemViewModel>>()
    val searchSchoolRecyclerViewItems: LiveData<List<SearchSchoolItemViewModel>> = _searchSchoolRecyclerItems

    fun register() {
        val request = RegisterEntity(userName.value!!, selectedSchoolName.value!!, userId.value!!, password.value!!)
        repository.register(request).subscribe { response ->
            if(response.isSuccessful) {
                doneRegister.call()
            }
        }
    }

    fun searchSchool(name: String) {
        repository.searchSchool(name).subscribe { response ->
            if(response.body() != null) {
                _searchSchoolRecyclerItems.value = response.body()!!.map { SearchSchoolItemViewModel(it) }
            }
        }
    }

    inner class SearchSchoolItemViewModel(private val data: SchoolEntity, private val viewModel: RegisterViewModel = this) {
        fun selectSchool() {
            viewModel._selectedSchoolName.value = data.name
        }
    }
}