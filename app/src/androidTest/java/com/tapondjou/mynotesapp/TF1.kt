package com.tapondjou.mynotesapp


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.junit.BeforeClass
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import tools.fastlane.screengrab.FalconScreenshotStrategy
import tools.fastlane.screengrab.Screengrab
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy
import tools.fastlane.screengrab.locale.LocaleTestRule

@LargeTest
@RunWith(AndroidJUnit4::class)
class TF1 {

    @get:Rule
    var mActivityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Rule @JvmField
    val localeTestRule = LocaleTestRule()

    @Test
    fun createNoteTest(){

        val title = "My Title"
        val desc = "My Description"

        //Click on the add note button
        onView(withId(R.id.fab)).perform(click())

        //Add note's information
        onView(withId(R.id.edt_note_title)).perform(typeText(title))
        onView(withId(R.id.edt_note_description)).perform(typeText(desc), closeSoftKeyboard())
        onView(withId(R.id.spinner_for_priority)).perform(click());
        //Set notes's priority to 4
        onData(allOf(`is`(instanceOf(String::class.java)),
            `is`("4"))).perform(click())
        onView(withId(R.id.checkBox_color)).perform(click());


        //Save the note
        onView(withId(R.id.button_create_note)).perform(click())

        //Verify that note is displayed on screen
        onView(withText(title)).check(matches(isDisplayed()))
        onView(withText(desc)).check(matches(isDisplayed()))
        onView(withText("4")).check(matches(isDisplayed()))
        onView(withText("Checked")).check(matches(isDisplayed()))


    }


}
