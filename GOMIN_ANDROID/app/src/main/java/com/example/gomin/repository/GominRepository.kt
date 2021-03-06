package com.example.gomin.repository

import com.example.gomin.dto.GominDetail
import com.example.gomin.dto.GominList
import com.example.gomin.dto.GominUpload
import com.example.gomin.remote.api.GominApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class GominRepository(private val gominApi: GominApi) {

    fun showGominList(): @NonNull Single<Response<List<GominList>>> =
        gominApi.showGominList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    //TODO 여기서 query를 어떻게 전달하는지?
    fun showGominListDetail(gomin : String): @NonNull Single<Response<GominDetail>> =
        gominApi.showGominListDetail(gomin).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun writeComment(id : String): @NonNull Single<Response<Unit>> =
        gominApi.writeComment(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun symPerson(id : String): @NonNull Single<Response<Unit>> =
        gominApi.symPerson(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun gominUpload(gominUp : GominUpload): @NonNull Single<Response<Unit>> =
        gominApi.gominUpload(gominUp).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}