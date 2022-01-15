package com.example.gomin.remote.api

import com.example.gomin.model.SchoolEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginApi {
    @GET("search/{name}")
    fun searchSchool(@Query("name") name: String): Single<Response<List<SchoolEntity>>>
}