package sulistiyanto.com.rajaongkirtest.data

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import sulistiyanto.com.rajaongkirtest.data.model.city.CityModel
import sulistiyanto.com.rajaongkirtest.data.model.province.ProvinceModel
import javax.inject.Inject

class RajaRepo @Inject constructor(private val apiService: APIService) {

    fun getProvince(
        key: String,
        response: (List<ProvinceModel>?) -> Unit,
        error: (Throwable) -> Unit
    ): Disposable =
        apiService.getProvince(key)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .subscribe(
                {
                    response(it?.province?.results)
                },
                { error(it) }
            )

    fun getCity(
        key: String,
        response: (List<CityModel>?) -> Unit,
        error: (Throwable) -> Unit
    ): Disposable =
        apiService.getCity(key)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .subscribe(
                {
                    response(it?.city?.results)
                },
                { error(it) }
            )
}