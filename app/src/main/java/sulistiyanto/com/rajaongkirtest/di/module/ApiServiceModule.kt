package sulistiyanto.com.rajaongkirtest.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import sulistiyanto.com.rajaongkirtest.data.APIService
import javax.inject.Singleton

@Module
class ApiServiceModule {

    @Provides
    @Singleton
    fun providesApiServiceBook(retrofit: Retrofit): APIService =
        retrofit.create(APIService::class.java)
}