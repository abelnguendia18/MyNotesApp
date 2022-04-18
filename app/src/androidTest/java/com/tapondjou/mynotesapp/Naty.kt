package com.tapondjou.mynotesapp

import androidx.test.core.app.ActivityScenario
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import tools.fastlane.screengrab.Screengrab
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy

@RunWith(JUnit4::class)
class Naty {
    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        Screengrab.setDefaultScreenshotStrategy(UiAutomatorScreenshotStrategy())
    }

    @Test
    fun captureScreen() {
        // Delay 500 millis for app launch to main screen
        Thread.sleep(500)
        Screengrab.screenshot("main_screen")
    }
}