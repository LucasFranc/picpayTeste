package franco.lucas.testepicpay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.UserListAdapter
import franco.lucas.testepicpay.databinding.ActivityMainBinding
import franco.lucas.testepicpay.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        layout.executePendingBindings()
        layout.setVariable(BR.mainViewModel,viewModel)
        layout.lifecycleOwner = this
        val adapter = UserListAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = adapter
        viewModel.init()
    }
}
