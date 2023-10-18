package com.mshdabiola.datastore

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

class IntToStringMigrationTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun migrate() = runTest {
        val userPreferences = userPreferences { }

        IntToStringMigration.migrate(userPreferences)
    }

    @Test
    fun shouldMigrate() {
    }
}
