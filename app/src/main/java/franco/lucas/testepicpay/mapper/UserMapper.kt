package franco.lucas.testepicpay.mapper

import franco.lucas.testepicpay.model.UserModel
import franco.lucas.testepicpay.model.UserPM

class UserMapper {

    fun map(list: List<UserModel>?): UserPM {
        return UserPM(list)
    }
}