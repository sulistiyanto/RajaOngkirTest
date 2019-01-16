package sulistiyanto.com.rajaongkirtest.local.province

import android.util.Log
import io.realm.Case
import io.realm.Realm
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProvinceHelper @Inject constructor() : ProvinceInterface {

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


    override fun searchProvinceByName(realm: Realm, provinceName: String): List<Province> =
        realm.where(Province::class.java).contains("province", provinceName, Case.INSENSITIVE).findAll()

}