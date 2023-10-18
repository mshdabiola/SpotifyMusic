package com.mshdabiola.datastore

import androidx.datastore.core.DataMigration

object IntToStringMigration : DataMigration<UserPreferences> {
    override suspend fun cleanUp() {
    }

    override suspend fun migrate(currentData: UserPreferences): UserPreferences {
        return currentData.copy {
            yes = true

            // true for migrate
        }
    }

    override suspend fun shouldMigrate(currentData: UserPreferences): Boolean {
        return false
    }
}
