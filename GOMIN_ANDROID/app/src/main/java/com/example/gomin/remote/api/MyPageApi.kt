package com.example.gomin.remote.api

import com.example.gomin.model.MyGominEntity
import com.example.gomin.model.MyInfoEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET

interface MyPageApi {
    @GET("member/info")
    fun getUserInfo(): Single<Response<MyInfoEntity>>

    @GET("member/my/page")
    fun getUserGominList(): Single<Response<List<MyGominEntity>>>
}