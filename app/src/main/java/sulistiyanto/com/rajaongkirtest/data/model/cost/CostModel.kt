package sulistiyanto.com.rajaongkirtest.data.model.cost

import com.google.gson.annotations.SerializedName


data class CostsResultModel(
    @SerializedName("code") val code: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("costs") val costs: CostsModel?
)

data class CostsModel(
    @SerializedName("service") val service: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("cost") val cost: CostModel?
)

data class CostModel(
    @SerializedName("value") val value: Int?,
    @SerializedName("etd") val etd: String?,
    @SerializedName("note") val note: String?
)