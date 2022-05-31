package com.tapondjou.mynotesapp


import androidx.test.espresso.Espresso.onView
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
class TF3 {

    @get:Rule
    var mActivityTestRule = ActivityScenarioRule(CreateNote::class.java)

    @Rule
    @JvmField
    val localeTestRule = LocaleTestRule()

    @Test
    fun createNoteScreenLocalisationTest(){

        onView(withId(R.id.edt_note_title)).check(matches(withHint(R.string.note_title_label)))
        onView(withId(R.id.edt_note_description)).check(matches(withHint(R.string.note_description_label)))
        onView(withId(R.id.tv_setPriority)).check(matches(withText(R.string.label_define_priority)))
        onView(withId(R.id.checkBox_color)).check(matches(withText(R.string.label_checkbox)))
        onView(withId(R.id.button_create_note)).check(matches(withText(R.string.create_note_label)))
        Thread.sleep(500)
        Screengrab.screenshot("test")

    }


}
