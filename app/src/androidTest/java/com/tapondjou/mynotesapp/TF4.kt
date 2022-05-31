package com.tapondjou.mynotesapp


import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class TF4 {

    @get:Rule
    var mActivityTestRule = ActivityScenarioRule(CreateNote::class.java)

    private var decorView: View? = null

    @Before
    fun loadDecorView() {
        mActivityTestRule.scenario.onActivity { activity ->
            decorView = activity.window.decorView
        }
    }

    @Test
    fun createEmptyNoteTest(){

        //Add empty note title and description
        onView(withId(R.id.edt_note_title)).perform(typeText(" "), closeSoftKeyboard())
        onView(withId(R.id.button_create_note)).perform(click())


        onView(withText("Title required")).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
        //Verify if error message is displayed
        //onView(withText("Title required")).inRoot(withDecorView(not(decorView))).check(matches(isDisplayed()))




    }


}
