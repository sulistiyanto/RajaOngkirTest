package sulistiyanto.com.rajaongkirtest.application

import android.app.Application
import sulistiyanto.com.rajaongkirtest.di.AppComponent
import sulistiyanto.com.rajaongkirtest.di.AppModule
import sulistiyanto.com.rajaongkirtest.di.DaggerAppComponent
import sulistiyanto.com.rajaongkirtest.di.module.ApiServiceModule
import sulistiyanto.com.rajaongkirtest.di.module.NetworkModule

open class MyApplication: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .apiServiceModule(ApiServiceModule())
            .appModule(AppModule(applicationContext))
            .build()
    }
}