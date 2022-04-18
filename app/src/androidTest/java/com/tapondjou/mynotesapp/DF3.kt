package com.tapondjou.mynotesapp


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class DF3 {

    @get:Rule
    var mActivityTestRule = ActivityScenarioRule(MainActivity::class.java)

    private var decorView: View? = null

    @Before
    fun loadDecorView() {
        mActivityTestRule.scenario.onActivity { activity ->
            decorView = activity.window.decorView
        }
    }

    @Test
    fun createEmptyNoteTest(){

        //Click on the add note button
        onView(withId(R.id.fab)).perform(click())

        //Add empty note title and description
        onView(withId(R.id.edt_note_title)).perform(typeText(""))
        onView(withId(R.id.edt_note_description)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.button_create_note)).perform(click())

        //Verify if error message is displayed
        onView(withText(R.string.error_title_label)).inRoot(
            RootMatchers.withDecorView(
                Matchers.not(
                    decorView
                )
            )
        )
            .check(matches(isDisplayed()))

    }

}
