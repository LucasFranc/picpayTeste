package franco.lucas.testepicpay.repository

import franco.lucas.testepicpay.dataset.UsersLocalDataSet
import franco.lucas.testepicpay.dataset.UsersLocalDataSetImpl
import franco.lucas.testepicpay.dataset.UsersRemoteDataSet
import franco.lucas.testepicpay.dataset.UsersRemoteDataSetImpl
import franco.lucas.testepicpay.model.UserModel

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