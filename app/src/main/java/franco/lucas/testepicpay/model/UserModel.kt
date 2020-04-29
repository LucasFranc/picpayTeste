package franco.lucas.testepicpay.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class UserModel(
    @SerializedName("img") val img: String,
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("username") val username: String
)