package com.robertvargic.cryptochecker.database

import io.realm.DynamicRealm
import io.realm.RealmMigration
import io.realm.RealmSchema

class DatabaseMigration : RealmMigration {
    override fun migrate(realm: DynamicRealm?, oldVersion: Long, newVersion: Long) {
        var schema: RealmSchema = realm!!.schema
    }

}