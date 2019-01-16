package sulistiyanto.com.rajaongkirtest.local.province

import io.realm.Realm

interface ProvinceInterface {
    fun add(realm: Realm, province: Province): Boolean
    fun getProvince(realm: Realm): List<Province>
}