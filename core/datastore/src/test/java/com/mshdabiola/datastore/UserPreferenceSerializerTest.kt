package com.mshdabiola.datastore


import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

class UserPreferenceSerializerTest {

    val userPreferenceSerializer = UserPreferenceSerializer()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun defaultValue() {
        val userPreferences = userPreferences { }

        val defaultUserPreferences = userPreferenceSerializer.defaultValue

        assertEquals(userPreferences, defaultUserPreferences)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun readAndWriteUserPreference() = runTest {
        val expectedUserPreferences = userPreferences {
            yes = true
            integer = 67
        }

        val output = ByteArrayOutputStream()
        userPreferenceSerializer.writeTo(expectedUserPreferences, output)

        val input = ByteArrayInputStream(output.toByteArray())

        val actualUserPreferences = userPreferenceSerializer.readFrom(input)

        assertEquals(expectedUserPreferences, actualUserPreferences)
    }
}
