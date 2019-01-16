package sulistiyanto.com.rajaongkirtest.data.model.city

import com.google.gson.annotations.SerializedName
import sulistiyanto.com.rajaongkirtest.data.model.StatusModel

data class CityResponse(
    @SerializedName("rajaongkir") val city: CityResponseModel
)

data class CityResponseModel(
    @SerializedName("status") val status: StatusModel?,
    @SerializedName("results") val results: List<CityModel>?
)