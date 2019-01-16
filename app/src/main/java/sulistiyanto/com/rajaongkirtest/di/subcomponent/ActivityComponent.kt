package sulistiyanto.com.rajaongkirtest.di.subcomponent

import dagger.Subcomponent
import sulistiyanto.com.rajaongkirtest.ui.MainActivity
import sulistiyanto.com.rajaongkirtest.ui.city.SearchCityActivity

@Subcomponent
interface ActivityComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): ActivityComponent
    }

    fun inject(mainActivity: MainActivity)
    fun inject(searchCityActivity: SearchCityActivity)
}