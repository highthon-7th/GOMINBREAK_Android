package com.example.gomin.repository

import com.example.gomin.dto.RefreshTokenRequest
import com.example.gomin.dto.RefreshTokenResponse
import com.example.gomin.local.LocalStorage
import com.example.gomin.remote.api.LoginApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import retrofit2.Response

class MainRepository(private val loginApi: LoginApi, private val localStorage: LocalStorage) {

    @OptIn(ExperimentalCoroutinesApi::class)
    fun refreshToken(): Single<Response<RefreshTokenResponse>> {
        val request = RefreshTokenRequest(localStorage.getRefreshToken())
        return loginApi.refreshToken(request).map { response ->
            if(response.isSuccessful) {
                localStorage.saveAccessToken(response.body()!!.accessToken)
            }
            response
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}