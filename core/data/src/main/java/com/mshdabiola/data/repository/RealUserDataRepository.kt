package com.mshdabiola.data.repository

import com.mshdabiola.datastore.UserPreferenceDataSource
import javax.inject.Inject

class RealUserDataRepository @Inject constructor(
    private val userPreference: UserPreferenceDataSource,
) : UserDataRepository {
    override suspend fun setTopic(id: Int) {
        userPreference.addTopic(id)
    }

    override suspend fun remove(id: Int) {
        userPreference.remove(id)
    }
}
