package com.example.gomin.repository

import com.example.gomin.model.MyInfoEntity
import com.example.gomin.remote.api.MyPageApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class MyPageRepository(private val myPageApi: MyPageApi) {

    fun getMyPageInfo(): Single<Response<MyInfoEntity>> =
        myPageApi.getUserInfo().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}