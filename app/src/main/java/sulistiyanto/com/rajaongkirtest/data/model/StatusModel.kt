package sulistiyanto.com.rajaongkirtest.data.model

import com.google.gson.annotations.SerializedName

data class StatusModel(
    @SerializedName("code") val code: Int?,
    @SerializedName("description") val description: String?
)