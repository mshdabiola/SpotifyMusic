package com.mshdabiola.datastore

import androidx.datastore.core.DataStoreFactory
import org.junit.rules.TemporaryFolder

fun TemporaryFolder.testUserPreferenceDataStore(
    userPreferenceSerializer: UserPreferenceSerializer = UserPreferenceSerializer(),
) =
    DataStoreFactory.create(serializer = userPreferenceSerializer) {
        newFile("user_preference_test.pb")
    }
