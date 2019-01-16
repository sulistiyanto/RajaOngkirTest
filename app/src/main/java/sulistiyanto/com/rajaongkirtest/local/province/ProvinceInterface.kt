package sulistiyanto.com.rajaongkirtest.local.province

import io.realm.Realm

interface ProvinceInterface {
    fun add(realm: Realm, province: Province): Boolean
    fun getProvince(realm: Realm): List<Province>
    fun searchProvinceByName(realm: Realm, provinceName: String): List<Province>
}