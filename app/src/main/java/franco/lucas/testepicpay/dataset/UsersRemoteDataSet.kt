package franco.lucas.testepicpay.dataset

import franco.lucas.testepicpay.service.Service
import franco.lucas.testepicpay.model.UserModel
import franco.lucas.testepicpay.retrofit.Client
import franco.lucas.testepicpay.retrofit.ClientImpl

interface UsersRemoteDataSet {
    suspend fun getUsersByRemote(): List<UserModel>
}

class UsersRemoteDataSetImpl : UsersRemoteDataSet {

    private var client: Client = ClientImpl() // poderia ser injetado por di

    override suspend fun getUsersByRemote(): List<UserModel> =
        client.getClientDefault().create(Service::class.java).getUsers().await()
}