package com.picpay.desafio.android.retrofit

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.picpay.desafio.android.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface Client {
    fun getClientDefault() : Retrofit
}

class ClientImpl : Client{
    var retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client( OkHttpClient.Builder().build())
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    override fun getClientDefault(): Retrofit = retrofit
}