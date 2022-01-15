package com.example.gomin.intercepter

import com.example.gomin.local.LocalStorage
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(private val localStorage: LocalStorage) : Interceptor {
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        val accessToken = localStorage.getAccessToken()
        if(accessToken.isNotEmpty()){
            request.addHeader("Authorization", accessToken)
        }
        return chain.proceed(request.build())
    }

}