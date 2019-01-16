package sulistiyanto.com.rajaongkirtest.ui.city

import io.realm.Realm
import sulistiyanto.com.rajaongkirtest.adapter.AdapterCity
import sulistiyanto.com.rajaongkirtest.data.RajaRepo
import sulistiyanto.com.rajaongkirtest.local.city.City
import sulistiyanto.com.rajaongkirtest.local.city.CityHelper
import sulistiyanto.com.rajaongkirtest.ui.base.BasePresenter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CityPresenter @Inject constructor(private val repo: RajaRepo) : BasePresenter<CityView>() {

    fun checkDataCity(realm: Realm, cityHelper: CityHelper) {
        val list = cityHelper.getCity(realm)
        if (list.count() == 0) {
            getCityFromAPI(realm, cityHelper)
        } else {
            getCityFromLocal(realm, cityHelper)
        }
    }

    private fun getCityFromAPI(realm: Realm, cityHelper: CityHelper) {
        disposables.add(
            repo.getCity("0df6d5bf733214af6c6644eb8717c92c",
                response = { cityList ->
                    for (item in cityList!!) {
                        val city = City(item.cityId!!, item.provinceId!!, item.province!!, item.type!!, item.cityName!!, item.postalCode!!)
                        cityHelper.add(realm, city)
                    }
                    getCityFromLocal(realm, cityHelper)
                },
                error = {
                    view?.displayError("Gagal mendapatkan data dari server")
                })
        )
    }

    private fun getCityFromLocal(realm: Realm, cityHelper: CityHelper) {
        val list = cityHelper.getCity(realm)
        val adapter = AdapterCity(list)
        view?.displayCity(adapter)
    }

    fun searchCity(
        newText: String,
        realm: Realm,
        cityHelper: CityHelper
    ) {
        val list = cityHelper.searchCityByName(realm, newText)
        val adapter = AdapterCity(list)
        view?.displayCity(adapter)
    }
}