package sulistiyanto.com.rajaongkirtest.data.model.province

import com.google.gson.annotations.SerializedName
import sulistiyanto.com.rajaongkirtest.data.model.StatusModel

data class ProvinceResponse(
    @SerializedName("rajaongkir") val province: ProvinceResponseModel
)

data class ProvinceResponseModel(
    @SerializedName("status") val status: StatusModel?,
    @SerializedName("results") val results: List<ProvinceModel>?
)