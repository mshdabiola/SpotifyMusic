package com.mshdabiola.tempapp

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class NavigationTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun buttonClick() {
        composeTestRule.apply {
            onNodeWithText("Add Test")
                .assertExists()

        }
    }

}