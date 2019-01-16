package sulistiyanto.com.rajaongkirtest.local.city

import io.realm.Realm
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CityHelper @Inject constructor() : CityInterface {

    override fun add(realm: Realm, city: City): Boolean {
        return try {
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(city)
            realm.commitTransaction()
            true
        } catch (e: Exception) {
            println(e)
            false
        }
    }

    override fun getCity(realm: Realm): List<City> = realm.where(City::class.java).findAll()

}