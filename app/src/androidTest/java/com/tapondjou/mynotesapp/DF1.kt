package com.tapondjou.mynotesapp


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.PositionAssertions
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
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class DF1 {

    @get:Rule
    var mActivityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    //TF1
    fun createNoteTest(){

        //Click on the add note button
        onView(withId(R.id.fab)).perform(click())

        //Add note title and description
        onView(withId(R.id.edt_note_title)).perform(typeText("Title"))
        onView(withId(R.id.edt_note_description)).perform(typeText("Description"), closeSoftKeyboard())

        //Save the note
        onView(withId(R.id.button_create_note)).perform(click())

        //Verify that note is displayed on screen
        onView(withText("Title")).check(matches(isDisplayed()))
        onView(withText("Description")).check(matches(isDisplayed()))
        //The title should be on top of the description
        onView(withText("Title")).check(PositionAssertions.isAbove(withText("Description")))

    }




}
