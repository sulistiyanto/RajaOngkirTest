package sulistiyanto.com.rajaongkirtest.data

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import sulistiyanto.com.rajaongkirtest.data.model.city.CityResponse
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
}