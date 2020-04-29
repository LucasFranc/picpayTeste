package franco.lucas.testepicpay.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.picpay.desafio.android.interactor.UsersInteractorImpl
import com.picpay.desafio.android.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.lang.NullPointerException

class MainViewModel {

    private val interactor = UsersInteractorImpl() //pode ser injetado
    val users = MutableLiveData<List<UserModel>>()
    val showLoading = MutableLiveData<Boolean>().apply { value = false }
    val errorMessage = MutableLiveData<String>()

    fun init(){
        GlobalScope.launch(Dispatchers.Main) {
            try {
                showLoading.value = true
                users.value = withContext(Dispatchers.IO) { interactor.execute(Unit).usersList}
            } catch (e: Exception) {
                errorMessage.value = "Erro Desconhecido, Tente novamente mais tarde"
                //msg de erro voltada pelo back end ou
                //resourceManager com contexto de aplicação injetado por di
            }finally {
                showLoading.value = false
            }
        }
    }
}