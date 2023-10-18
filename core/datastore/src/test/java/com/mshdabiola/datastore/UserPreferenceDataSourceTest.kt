package com.mshdabiola.datastore

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

@OptIn(ExperimentalCoroutinesApi::class)
class UserPreferenceDataSourceTest {

    private lateinit var userPreferenceDataSource: UserPreferenceDataSource

    @get:Rule
    val temporaryFolder: TemporaryFolder = TemporaryFolder.builder().assureDeletion().build()

    @Before
    fun setUp() {
        userPreferenceDataSource = UserPreferenceDataSource(
            temporaryFolder.testUserPreferenceDataStore(),
        )
    }

    @Test
    fun addTopic() = runTest {
        userPreferenceDataSource.addTopic(676)
        assertEquals(userPreferenceDataSource.userData.first().topicIds.first(), 674)
    }

    @Test
    fun remove() = runTest {
        userPreferenceDataSource.addTopic(58)
        userPreferenceDataSource.remove(58)

        print(userPreferenceDataSource.userData.first().topicIds)
        assertTrue(userPreferenceDataSource.userData.first().topicIds.isEmpty())
    }

    @Test
    fun setInteger() {
    }
}
