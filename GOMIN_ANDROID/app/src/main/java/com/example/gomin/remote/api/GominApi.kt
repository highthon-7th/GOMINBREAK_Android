package com.example.gomin.remote.api

import com.example.gomin.dto.GominList
import com.example.gomin.model.SchoolEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface GominApi {

    @GET("/gomin")
    fun showGominList(): Single<Response<List<GominList>>>

    @GET("/gomin/{gomin-id}")
    fun showGominListDetail(@Query("gomin-id") id : String): Single<Response<GominList>>

    @POST("search/{name}")
    fun gominUpdate(title :String,content : String): Single<Void>
}