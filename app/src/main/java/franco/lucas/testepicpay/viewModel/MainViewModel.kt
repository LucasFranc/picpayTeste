package franco.lucas.testepicpay.viewModel

import androidx.lifecycle.MutableLiveData
import franco.lucas.testepicpay.interactor.UsersInteractor
import franco.lucas.testepicpay.interactor.UsersInteractorImpl
import franco.lucas.testepicpay.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

//pode ser injetado
class MainViewModel(private val interactor: UsersInteractor = UsersInteractorImpl()) {

    val users = MutableLiveData<List<UserModel>>()
    val showLoading = MutableLiveData<Boolean>().apply { value = false }
    val errorMessage = MutableLiveData<String>()

    fun init(){
        GlobalScope.launch(Dispatchers.Main) {
            try {
                showLoading.value = true
                users.value = withContext(Dispatchers.IO) { interactor.execute(Unit).usersList}
            } catch (e: Exception) {
                errorMessage.value = e.message ?: "Erro Desconhecido, Tente novamente mais tarde"
                //msg de erro voltada pelo back end ou
                //resourceManager com contexto de aplicação injetado por di
            }finally {
                showLoading.value = false
            }
        }
    }
}