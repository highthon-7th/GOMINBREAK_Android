package com.example.gomin.remote.api

import com.example.gomin.dto.GominDetail
import com.example.gomin.dto.GominList
import com.example.gomin.dto.GominUpload
import com.example.gomin.model.SchoolEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface GominApi {

    @GET("/gomin")
    fun showGominList(): Single<Response<List<GominList>>>

    @GET("/gomin/{gomin-id}")
    fun showGominListDetail(@Path("gomin-id") id : String): Single<Response<GominDetail>>

    @POST("/comment/{gomin-id}")
    fun writeComment(@Path("gomin-id") id :String): Single<Response<Unit>>

    @POST("/sym/{comment-id}")
    fun symPerson( @Path("comment-id") id :String): Single<Response<Unit>>

    @POST("/gomin")
    fun gominUpload(gominUp : GominUpload): Single<Response<Unit>>

}