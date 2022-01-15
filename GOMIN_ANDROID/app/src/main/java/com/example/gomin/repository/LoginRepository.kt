package com.example.gomin.repository

import com.example.gomin.local.LocalStorage
import com.example.gomin.model.LoginEntity
import com.example.gomin.model.RegisterEntity
import com.example.gomin.model.SchoolEntity
import com.example.gomin.model.TokenEntity
import com.example.gomin.remote.api.LoginApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import retrofit2.Response

class LoginRepository(private val loginApi: LoginApi, private val localStorage: LocalStorage) {
    fun searchSchool(name: String): @NonNull Single<Response<List<SchoolEntity>>> =
        loginApi.searchSchool(name).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun register(registerEntity: RegisterEntity): Single<Response<Unit>> =
        loginApi.register(registerEntity).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    @OptIn(ExperimentalCoroutinesApi::class)
    fun login(loginEntity: LoginEntity): Single<Response<TokenEntity>> =
        loginApi.login(loginEntity).doOnSuccess {
            if (it.body() != null) {
                localStorage.saveAccessToken(it.body()!!.accessToken)
                localStorage.saveRefreshToken(it.body()!!.refreshToken)
            }
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}