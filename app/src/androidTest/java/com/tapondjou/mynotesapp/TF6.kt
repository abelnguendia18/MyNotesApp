package com.tapondjou.mynotesapp


import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class TF6 {

    @get:Rule
    var mActivityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun rotateScreen(){
        mActivityTestRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
    }

    @Test
    //TF1
    fun swipeTest(){
        onView(withId(R.id.recyclerview)).perform(swipeUp())
    }


}
