package com.tapondjou.mynotesapp


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.PositionAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class TF2 {

    @get:Rule
    var mActivityTestRule = ActivityScenarioRule(CreateNote::class.java)

    @Test
    //TF2
    fun itemsDisplayOnScreenTest(){
        val edt_title = onView(withId(R.id.edt_note_title))
        val edt_description = onView(withId(R.id.edt_note_description))
        val btn_create_note = onView(withId(R.id.button_create_note))
        onView(withText(R.string.new_note_label))
            .check(matches(isDisplayed()))
        edt_title.check(matches(isDisplayed()))
            .check(matches(withHint(R.string.note_title_label)))
            .check(PositionAssertions.isAbove(withId(R.id.edt_note_description)))
        edt_description.check(matches(isDisplayed()))
            .check(matches(withHint(R.string.note_description_label)))
            .check(PositionAssertions.isAbove(withId(R.id.button_create_note)))
        btn_create_note.check(matches(isDisplayed()))
            .check(matches(withText(R.string.create_note_label)))
    }

}
