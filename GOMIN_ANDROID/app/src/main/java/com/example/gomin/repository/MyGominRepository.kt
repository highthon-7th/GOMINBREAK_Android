package com.example.gomin.repository

import com.example.gomin.model.MyGominEntity
import com.example.gomin.remote.api.MyPageApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class MyGominRepository(private val mypageApi: MyPageApi) {

    fun getMyGomins(): @NonNull Single<Response<List<MyGominEntity>>> =
        mypageApi.getUserGominList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}