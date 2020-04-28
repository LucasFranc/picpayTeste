package com.picpay.desafio.android.service

import com.picpay.desafio.android.model.UserModel
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET


interface Service {

    @GET("users")
    fun getUsers(): Deferred<List<UserModel>>
}