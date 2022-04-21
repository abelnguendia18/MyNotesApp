package com.tapondjou.mynotesapp


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import tools.fastlane.screengrab.Screengrab
import tools.fastlane.screengrab.locale.LocaleTestRule

@LargeTest
@RunWith(AndroidJUnit4::class)
class TF1 {

    companion object{
        var cpt: Int = (10..1000).random()
    }

    @get:Rule
    var mActivityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Rule @JvmField
    val localeTestRule = LocaleTestRule()


    @Test
    fun createNoteTest(){
        setTitleAndDesc()
        val title = "Title $cpt"
        val desc = "Description $cpt"

        //Click on the add note button
        onView(withId(R.id.fab)).perform(click())

        //Add note title and description
        onView(withId(R.id.edt_note_title)).perform(typeText(title))
        onView(withId(R.id.edt_note_description)).perform(typeText(desc), closeSoftKeyboard())

        //Save the note
        onView(withId(R.id.button_create_note)).perform(click())

        //Verify that note is displayed on screen
        onView(withText(title)).check(matches(isDisplayed()))
        onView(withText(desc)).check(matches(isDisplayed()))

    }
    fun setTitleAndDesc(){
        cpt++

    }


}
