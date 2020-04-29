package franco.lucas.testepicpay.interactor

import franco.lucas.testepicpay.mapper.UserMapper
import franco.lucas.testepicpay.model.UserPM
import franco.lucas.testepicpay.repository.UsersRepositoryImpl

interface UsersInteractor : BaseInteractor<Unit, UserPM>

class UsersInteractorImpl : UsersInteractor {

    private val usersRepository = UsersRepositoryImpl()
    private val userMapper = UserMapper()

    override suspend fun execute(param: Unit): UserPM =
        userMapper.map(usersRepository.getUsers())
}