package com.robertvargic.cryptochecker.base

import android.app.Application
import io.realm.Realm

class CryptoChecker : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(applicationContext)
//        var config: RealmConfiguration = RealmConfiguration.Builder(applicationContext).deleteRealmIfMigrationNeeded().build()
    }
}