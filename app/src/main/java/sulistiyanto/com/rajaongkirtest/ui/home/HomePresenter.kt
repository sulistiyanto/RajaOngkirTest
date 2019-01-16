package sulistiyanto.com.rajaongkirtest.ui.home

import sulistiyanto.com.rajaongkirtest.data.RajaRepo
import sulistiyanto.com.rajaongkirtest.ui.base.BasePresenter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomePresenter @Inject constructor(private val repo: RajaRepo) : BasePresenter<HomeView>() {

    fun getCost() {
        disposables.add(repo.getCost("0df6d5bf733214af6c6644eb8717c92c",
            "501", "114", "1700", "jne",
            response = {},
            error = {}
        ))
    }

}