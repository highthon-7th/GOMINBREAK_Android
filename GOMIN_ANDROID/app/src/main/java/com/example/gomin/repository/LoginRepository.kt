package com.example.gomin.repository

import com.example.gomin.model.SchoolEntity
import com.example.gomin.remote.api.LoginApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class LoginRepository(private val loginApi: LoginApi) {
    fun searchSchool(name: String): Single<Response<List<SchoolEntity>>> =
        loginApi.searchSchool(name).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}