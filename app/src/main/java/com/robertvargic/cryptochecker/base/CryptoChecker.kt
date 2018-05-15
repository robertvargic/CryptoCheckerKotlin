package com.robertvargic.cryptochecker.base

import android.app.Application
import com.robertvargic.cryptochecker.database.DatabaseMigration
import io.realm.Realm
import io.realm.RealmConfiguration

class CryptoChecker : Application() {

    val REALM_FILE_NAME = "cryptoCheker.realm"
    val SCHEMA_VERSION : Long = 0

    override fun onCreate() {
        super.onCreate()
        Realm.init(applicationContext)
        var config: RealmConfiguration = RealmConfiguration.Builder()
                .name(REALM_FILE_NAME)
                .schemaVersion(SCHEMA_VERSION)
                .migration(DatabaseMigration())
                .build()
        Realm.setDefaultConfiguration(config)
    }
}