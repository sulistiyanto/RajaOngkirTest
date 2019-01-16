package sulistiyanto.com.rajaongkirtest.local.province

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Province (
    @PrimaryKey open var provinceId: String = "",
    open var province: String = ""
): RealmObject()