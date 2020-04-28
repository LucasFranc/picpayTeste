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

class MainViewModel {

    private val interactor = UsersInteractorImpl()
    val users = MutableLiveData<List<UserModel>>()

    fun init(){
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val teste = withContext(Dispatchers.IO) { interactor.execute(Unit).usersList}
                users.value = teste
            } catch (e: Exception) {
                Log.i("ex", "e", e.cause)
            }
        }
    }

}