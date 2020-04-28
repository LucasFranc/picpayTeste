package com.picpay.desafio.android.interactor

import com.picpay.desafio.android.mapper.UserMapper
import com.picpay.desafio.android.model.UserModel
import com.picpay.desafio.android.model.UserPM
import com.picpay.desafio.android.repository.UsersRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

interface UsersInteractor : BaseInteractor<Unit, UserPM>

class UsersInteractorImpl : UsersInteractor {

    private val usersRepository = UsersRepositoryImpl()
    private val userMapper = UserMapper()

    override suspend fun execute(param: Unit): UserPM =
        userMapper.map(usersRepository.getUsers())
}