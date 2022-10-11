package com.example.jpc

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun test_11() {
        val text = composeTestRule.activity.getString(R.string.stringtest, 0)
        composeTestRule.onNodeWithText(text).assertExists()
    }

    @Test
    fun test_2() {
        val strings = composeTestRule.activity.getString(R.string.stringtestBtn)
        val text = composeTestRule.activity.getString(R.string.stringtest, 1)
        composeTestRule.onNodeWithText(strings).performClick()
        composeTestRule.onNodeWithText(text = text).assertExists()

    }
}