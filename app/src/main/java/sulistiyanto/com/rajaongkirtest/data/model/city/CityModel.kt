package sulistiyanto.com.rajaongkirtest.data.model.city

import com.google.gson.annotations.SerializedName

data class CityModel(
    @SerializedName("city_id") val cityId: String?,
    @SerializedName("province_id") val provinceId: String?,
    @SerializedName("province") val province: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("city_name") val cityName: String?,
    @SerializedName("postal_code") val postalCode: String?
)