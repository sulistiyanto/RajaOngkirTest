package sulistiyanto.com.rajaongkirtest.local

import io.realm.Realm
import sulistiyanto.com.rajaongkirtest.local.province.Province


class RealmHelper(val realm: Realm) {

    // untuk menyimpan data
    fun save(mahasiswaModel: Province) {
//        realm.executeTransaction { realm ->
//            if (realm != null) {
//                Log.e("Created", "Database was created")
//                val currentIdNum = realm.where(Province::class.java!!).max("_ID")
//                val nextId: Int
//                if (currentIdNum == null) {
//                    nextId = 1
//                } else {
//                    nextId = currentIdNum!!.toInt() + 1
//                }
//                mahasiswaModel._ID(nextId)
//                val model = realm.copyToRealm(mahasiswaModel)
//            } else {
//                Log.e("no", "execute: Database not Exist")
//            }
//        }
    }

    // untuk memanggil semua data
    fun getAllMahasiswa(): List<Province> {
        return realm.where(Province::class.java).findAll()
    }
}