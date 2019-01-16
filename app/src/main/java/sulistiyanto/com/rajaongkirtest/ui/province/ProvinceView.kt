package sulistiyanto.com.rajaongkirtest.ui.province

import sulistiyanto.com.rajaongkirtest.adapter.AdapterProvince
import sulistiyanto.com.rajaongkirtest.ui.base.BaseView

interface ProvinceView: BaseView {
    fun displayProvince(adapter: AdapterProvince)
}