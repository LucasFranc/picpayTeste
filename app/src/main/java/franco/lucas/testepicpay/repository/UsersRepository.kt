package com.picpay.desafio.android.repository

import com.picpay.desafio.android.dataset.UsersLocalDataSet
import com.picpay.desafio.android.dataset.UsersRemoteDataSet
import com.picpay.desafio.android.model.UserModel

interface UsersRepository {
    suspend fun getUsers(): List<UserModel>?
}

class UsersRepositoryImpl : UsersRepository {

    private val usersLocalDataSet = UsersLocalDataSet()
    private val usersRemoteDataSet = UsersRemoteDataSet()

    override suspend fun getUsers(): List<UserModel>? {
        return usersLocalDataSet.getUsersByLocal() ?: usersRemoteDataSet.getUsersByRemote()
    }
}