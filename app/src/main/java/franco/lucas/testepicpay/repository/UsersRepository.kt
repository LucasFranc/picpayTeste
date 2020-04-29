package com.picpay.desafio.android.repository

import com.picpay.desafio.android.dataset.UsersLocalDataSet
import com.picpay.desafio.android.dataset.UsersLocalDataSetImpl
import com.picpay.desafio.android.dataset.UsersRemoteDataSet
import com.picpay.desafio.android.dataset.UsersRemoteDataSetImpl
import com.picpay.desafio.android.model.UserModel

interface UsersRepository {
    suspend fun getUsers(): List<UserModel>?
}

class UsersRepositoryImpl(
    val usersLocalDataSet : UsersLocalDataSet = UsersLocalDataSetImpl(),
    val usersRemoteDataSet : UsersRemoteDataSet = UsersRemoteDataSetImpl()
) : UsersRepository {



    override suspend fun getUsers(): List<UserModel>? {
        return usersLocalDataSet.getUsersByLocal() ?: usersRemoteDataSet.getUsersByRemote()
    }
}