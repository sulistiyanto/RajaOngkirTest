package sulistiyanto.com.rajaongkirtest.ui.province

import android.util.Log
import io.realm.Realm
import sulistiyanto.com.rajaongkirtest.data.RajaRepo
import sulistiyanto.com.rajaongkirtest.local.province.Province
import sulistiyanto.com.rajaongkirtest.local.province.ProvinceHelper
import sulistiyanto.com.rajaongkirtest.ui.base.BasePresenter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProvincePresenter @Inject constructor(private val repo: RajaRepo) : BasePresenter<ProvinceView>() {

    fun checkDataProvince(
        realm: Realm,
        provinceHelper: ProvinceHelper
    ) {
        val list = provinceHelper.getProvince(realm)
        if (list.count() == 0) {
            getProvinceFromAPI(realm, provinceHelper)
        } else {
            getProvinceFromLocal(realm, provinceHelper)
        }
    }

    private fun getProvinceFromAPI(
        realm: Realm,
        provinceHelper: ProvinceHelper
    ) {
        disposables.add(
            repo.getProvince("0df6d5bf733214af6c6644eb8717c92c",
                response = { provinceList ->
                    for (item in provinceList!!) {
                        val prov = Province(item.provinceId!!, item.province!!)
                        provinceHelper.add(realm, prov)
                    }
                    getProvinceFromLocal(realm, provinceHelper)
                },
                error = {
                    view?.displayError("Gagal mendapatkan data dari server")
                })
        )
    }

    private fun getProvinceFromLocal(
        realm: Realm,
        provinceHelper: ProvinceHelper
    ) {
        Log.d("data", "hahaha")
    }
}