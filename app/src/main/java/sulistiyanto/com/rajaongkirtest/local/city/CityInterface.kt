package sulistiyanto.com.rajaongkirtest.local.city

import io.realm.Realm

interface CityInterface {
    fun add(realm: Realm, city: City): Boolean
    fun getCity(realm: Realm): List<City>
    fun searchCityByName(realm: Realm, cityName: String): List<City>
}