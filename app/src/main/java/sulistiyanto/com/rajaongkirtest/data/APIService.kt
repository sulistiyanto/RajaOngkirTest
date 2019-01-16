package sulistiyanto.com.rajaongkirtest.data

import io.reactivex.Observable
import retrofit2.http.*
import sulistiyanto.com.rajaongkirtest.data.model.city.CityResponse
import sulistiyanto.com.rajaongkirtest.data.model.cost.CostResponse
import sulistiyanto.com.rajaongkirtest.data.model.province.ProvinceResponse

interface APIService {

    @GET("starter/province")
    fun getProvince(
        @Header("key") key: String
    ): Observable<ProvinceResponse?>

    @GET("starter/city")
    fun getCity(
        @Header("key") key: String
    ): Observable<CityResponse?>

    @FormUrlEncoded
    @POST("starter/cost")
    fun cost(
        @Header("key") key: String,
        @Field("origin") origin: String,
        @Field("destination") destination: String,
        @Field("weight") weight: String,
        @Field("courier") courier: String
    ): Observable<CostResponse?>
}