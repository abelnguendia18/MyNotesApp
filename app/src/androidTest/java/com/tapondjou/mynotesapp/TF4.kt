package com.tapondjou.mynotesapp


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
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
