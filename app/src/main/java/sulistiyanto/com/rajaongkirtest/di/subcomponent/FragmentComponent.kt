package sulistiyanto.com.rajaongkirtest.di.subcomponent

import dagger.Subcomponent
import sulistiyanto.com.rajaongkirtest.ui.city.CityFragment
import sulistiyanto.com.rajaongkirtest.ui.home.HomeFragment
import sulistiyanto.com.rajaongkirtest.ui.province.ProvinceFragment

@Subcomponent
interface FragmentComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): FragmentComponent
    }

    fun inject(homeFragment: HomeFragment)
    fun inject(cityFragment: CityFragment)
    fun inject(provinceFragment: ProvinceFragment)
}