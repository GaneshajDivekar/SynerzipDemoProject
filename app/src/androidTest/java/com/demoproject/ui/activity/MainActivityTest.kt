package com.demoproject.ui.activity

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.demoproject.R
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun testBackButton() {
        Espresso.pressBackUnconditionally()
    }

    @Test
    fun testClickSearch() {
        onView(withId(R.id.search_button)).perform(click())
    }

    @Test
    fun testHomeIsDisplayed() {
        onView(withText("Home")).check(matches(isDisplayed()))
    }


    @Test
    fun testTypAndSearch() {
        onView(withId(R.id.searchEditText))
            .perform(typeText("Pune"), closeSoftKeyboard())
        onView(withId(R.id.searchEditText))
            .check(matches(withText("Pune")))
        onView(withId(R.id.search_button)).perform(click())
    }


    @Test
    fun testCheckTypeText() {
        onView(withId(R.id.searchEditText))
            .check(matches(withText("abc")))
    }

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testActivityShouldNotBeNull() {
        assertNotNull(activityRule)
    }

}