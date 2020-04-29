package franco.lucas.testepicpay.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import franco.lucas.testepicpay.ui.AdapterItensContract

@BindingAdapter("bind:items")
fun RecyclerView.setItems(list :List<Any>?){
    list?.let {
        val adapter = adapter
        if(adapter is AdapterItensContract){
            adapter.replaceItens(list)
        }
    }

}