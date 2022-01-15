package com.example.gomin.remote.api

import com.example.gomin.dto.RefreshTokenRequest
import com.example.gomin.dto.RefreshTokenResponse
import com.example.gomin.model.LoginEntity
import com.example.gomin.model.RegisterEntity
import com.example.gomin.model.SchoolEntity
import com.example.gomin.model.TokenEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.*

interface LoginApi {

    @GET("search/{name}")
    fun searchSchool(@Query("name") name: String): Single<Response<List<SchoolEntity>>>

    @POST("register")
    fun register(@Body request: RegisterEntity): Single<Response<Unit>>

    @POST("login")
    fun login(@Body request: LoginEntity): Single<Response<TokenEntity>>

    @PATCH("token")
    fun refreshToken(@Body request: RefreshTokenRequest): Single<Response<RefreshTokenResponse>>
}