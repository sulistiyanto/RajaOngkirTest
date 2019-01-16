package sulistiyanto.com.rajaongkirtest.ui.city

import sulistiyanto.com.rajaongkirtest.adapter.AdapterCity
import sulistiyanto.com.rajaongkirtest.ui.base.BaseView

interface CityView: BaseView {
    fun displayCity(adapter: AdapterCity)
}