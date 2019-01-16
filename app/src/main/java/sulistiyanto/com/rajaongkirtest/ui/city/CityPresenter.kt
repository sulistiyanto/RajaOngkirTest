package sulistiyanto.com.rajaongkirtest.ui.city

import sulistiyanto.com.rajaongkirtest.data.RajaRepo
import sulistiyanto.com.rajaongkirtest.ui.base.BasePresenter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CityPresenter @Inject constructor(private val repo: RajaRepo) : BasePresenter<CityView>() {

    fun checkDataCity() {

    }

    fun getCityFromAPI() {
        disposables.add(repo.getCity("0df6d5bf733214af6c6644eb8717c92c",
            response = {},
            error = {
                view?.displayError("Gagal mendapatkan data dari server")
            }))
    }

    fun getCityFromLocal() {

    }
}