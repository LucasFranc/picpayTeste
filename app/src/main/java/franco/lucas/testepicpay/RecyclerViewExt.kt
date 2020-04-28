package franco.lucas.testepicpay

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("bind:items")
fun RecyclerView.setItems(list :List<Any>?){
    list?.let {
        val adapter = adapter
        if(adapter is AdapterItensContract){
            adapter.replaceItens(list)
        }
    }

}