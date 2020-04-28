package com.picpay.desafio.android.mapper

import com.picpay.desafio.android.model.UserModel
import com.picpay.desafio.android.model.UserPM

class UserMapper {

    fun map(list: List<UserModel>?): UserPM {
        return UserPM(list)
    }
}