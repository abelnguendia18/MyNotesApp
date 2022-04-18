package com.tapondjou.mynotesapp


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@LargeTest
@RunWith(AndroidJUnit4::class)
class TF4 {

    @get:Rule
    var mActivityTestRule = ActivityScenarioRule(CreateNote::class.java)

    @Test
    fun createNoteScreenInEnglishTest(){
        setEnglishAsLanguage()
        onView(withId(R.id.edt_note_title)).check(matches(withHint(R.string.note_title_label)))
        onView(withId(R.id.edt_note_description)).check(matches(withHint(R.string.note_description_label)))

    }

    @Test
    fun createNoteScreenInGermanTest(){
        setGermanAsLanguage()
        onView(withId(R.id.edt_note_title)).check(matches(withHint(R.string.note_title_label)))
        onView(withId(R.id.edt_note_description)).check(matches(withHint(R.string.note_description_label)))

    }


   fun setEnglishAsLanguage(){
        setLocalization("en", "EN")
    }

    fun setGermanAsLanguage(){
        setLocalization("de", "DE")
    }

    private fun setLocalization(language: String,  country: String){
        val locale = Locale(language, country)
        Locale.setDefault(locale)
        //Update locale for app resources
        val res = InstrumentationRegistry.getInstrumentation().targetContext.resources
        val config = res.configuration
        config.locale = locale
        res.updateConfiguration(config, res.displayMetrics)
    }

}
