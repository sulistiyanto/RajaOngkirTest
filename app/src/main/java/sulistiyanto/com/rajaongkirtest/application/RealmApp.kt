package sulistiyanto.com.rajaongkirtest.application

import io.realm.Realm
import io.realm.RealmConfiguration


class RealmApp: MyApplication() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val configuration = RealmConfiguration.Builder()
            .name("raja_ongkir.db")
            .schemaVersion(0)
            .build()
        Realm.setDefaultConfiguration(configuration)
    }
}