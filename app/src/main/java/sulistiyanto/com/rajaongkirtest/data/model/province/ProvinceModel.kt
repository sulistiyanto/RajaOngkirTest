package sulistiyanto.com.rajaongkirtest.data.model.province

import com.google.gson.annotations.SerializedName

data class ProvinceModel(
    @SerializedName("province_id") val provinceId: String?,
    @SerializedName("province") val province: String?
)