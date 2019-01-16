package sulistiyanto.com.rajaongkirtest.di

import dagger.Component
import sulistiyanto.com.rajaongkirtest.di.module.ApiServiceModule
import sulistiyanto.com.rajaongkirtest.di.module.NetworkModule
import sulistiyanto.com.rajaongkirtest.di.subcomponent.ActivityComponent
import sulistiyanto.com.rajaongkirtest.di.subcomponent.FragmentComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    ApiServiceModule::class
])
interface AppComponent {
    fun activityComponent(): ActivityComponent.Builder
    fun fragmentComponent(): FragmentComponent.Builder
}