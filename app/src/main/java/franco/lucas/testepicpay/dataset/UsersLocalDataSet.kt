package franco.lucas.testepicpay.dataset

import franco.lucas.testepicpay.model.UserModel

interface UsersLocalDataSet {
    fun getUsersByLocal(): List<UserModel>?
}

class UsersLocalDataSetImpl : UsersLocalDataSet {

    val list: List<UserModel>? = null

    override fun getUsersByLocal(): List<UserModel>? {
        return list
    }
}
