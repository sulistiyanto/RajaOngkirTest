package sulistiyanto.com.rajaongkirtest.local.city

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class City(
    @PrimaryKey open var cityId: String = "",
    open var provinceId: String = "",
    open var province: String = "",
    open var type: String = "",
    open var cityName: String = "",
    open var postalCode: String = ""
) : RealmObject()