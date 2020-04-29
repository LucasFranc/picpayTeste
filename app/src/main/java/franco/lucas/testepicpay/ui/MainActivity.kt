package franco.lucas.testepicpay.ui

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import franco.lucas.testepicpay.BR
import franco.lucas.testepicpay.R
import franco.lucas.testepicpay.databinding.ActivityMainBinding
import franco.lucas.testepicpay.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindLayout()
        viewModel.init()
        bindRecyclerView()
        bindObservers()
    }

    private fun bindObservers() {
        viewModel.errorMessage.observe(this, Observer {
            if(!it.isNullOrEmpty()){
                AlertDialog.Builder(this@MainActivity)
                    .setTitle(getString(R.string.error_title))
                    .setMessage(it)
                    .show()
            }
        })
    }

    //poderia estar numa base
    private fun bindLayout() {
        val layout = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        layout.executePendingBindings()
        layout.setVariable(BR.mainViewModel, viewModel)
        layout.lifecycleOwner = this
    }

    private fun bindRecyclerView() {
        val adapter = UserListAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = adapter
    }
}
