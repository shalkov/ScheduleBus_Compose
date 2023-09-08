package ru.shalkoff.test.navigation

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import ru.shalkoff.schedulebus.MainActivity

@HiltAndroidTest
class NavigationTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun test1() {
        val itemNode = composeTestRule.onNodeWithTag("item_0")
        itemNode.assertExists()
        itemNode.performClick()
        val backButtonNode = composeTestRule.onNodeWithTag("nav_icon")
        backButtonNode.assertExists()
        backButtonNode.performClick()
    }
}

