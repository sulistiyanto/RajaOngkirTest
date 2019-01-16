package sulistiyanto.com.rajaongkirtest.local.province

import io.realm.Realm
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProvinceHelper @Inject constructor(): ProvinceInterface {

    override fun add(realm: Realm, province: Province): Boolean {
        return try {
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(province)
            realm.commitTransaction()
            true
        } catch (e: Exception) {
            println(e)
            false
        }
    }

    override fun getProvince(realm: Realm): List<Province> = realm.where(Province::class.java).findAll()
}