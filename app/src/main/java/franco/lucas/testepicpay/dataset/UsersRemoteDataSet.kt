package com.picpay.desafio.android.dataset

import com.picpay.desafio.android.service.Service
import com.picpay.desafio.android.model.UserModel
import com.picpay.desafio.android.retrofit.Client
import com.picpay.desafio.android.retrofit.ClientImpl

class UsersRemoteDataSet {

    private var client: Client = ClientImpl() // poderia ser injetado por di

    suspend fun getUsersByRemote(): List<UserModel> =
        client.getClientDefault().create(Service::class.java).getUsers().await()
}