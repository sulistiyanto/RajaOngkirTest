package sulistiyanto.com.rajaongkirtest.data.model.cost

import com.google.gson.annotations.SerializedName
import sulistiyanto.com.rajaongkirtest.data.model.StatusModel

data class CostResponse(
    @SerializedName("rajaongkir") val cost: CostResponseModel
)

data class CostResponseModel(
    @SerializedName("status") val status: StatusModel?,
    @SerializedName("results") val results: List<CostsResultModel>?
)