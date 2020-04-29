package franco.lucas.testepicpay.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import franco.lucas.testepicpay.model.UserModel
import franco.lucas.testepicpay.R

class UserListAdapter : RecyclerView.Adapter<UserListItemViewHolder>(), AdapterItensContract {

    var users = mutableListOf<UserModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_user, parent, false)

        return UserListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserListItemViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    override fun replaceItens(list: List<Any>) {
        users.clear()
        val updatedList = list.mapNotNull {
            val cast = it
            if(cast is UserModel) {
                cast
            }else{
                null
            }
        }
        users.addAll(updatedList)
        notifyDataSetChanged()
    }
}