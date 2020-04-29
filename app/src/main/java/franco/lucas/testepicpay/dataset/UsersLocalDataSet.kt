package com.picpay.desafio.android.dataset

import com.picpay.desafio.android.model.UserModel

interface UsersLocalDataSet {
    fun getUsersByLocal(): List<UserModel>?
}

class UsersLocalDataSetImpl : UsersLocalDataSet{

    val list: List<UserModel>? = null

    override fun getUsersByLocal(): List<UserModel>? {
        return list
    }
}
