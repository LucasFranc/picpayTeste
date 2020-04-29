package franco.lucas.testepicpay.service

import franco.lucas.testepicpay.model.UserModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET


interface Service {

    @GET("users")
    fun getUsers(): Deferred<List<UserModel>>
}