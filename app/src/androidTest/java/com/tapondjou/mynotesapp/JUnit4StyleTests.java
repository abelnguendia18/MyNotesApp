package com.tapondjou.mynotesapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import tools.fastlane.screengrab.Screengrab;
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy;
import tools.fastlane.screengrab.cleanstatusbar.BluetoothState;
import tools.fastlane.screengrab.cleanstatusbar.CleanStatusBar;
import tools.fastlane.screengrab.cleanstatusbar.MobileDataType;
import tools.fastlane.screengrab.locale.LocaleTestRule;

@RunWith(JUnit4.class)
public class JUnit4StyleTests {
    @ClassRule
    public static final LocaleTestRule localeTestRule = new LocaleTestRule();

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @BeforeClass
    public static void beforeAll() {
        Screengrab.setDefaultScreenshotStrategy(new UiAutomatorScreenshotStrategy());

        new CleanStatusBar()
                .setMobileNetworkDataType(MobileDataType.LTE)
                .setBluetoothState(BluetoothState.DISCONNECTED)
                .enable();
    }

    @AfterClass
    public static void afterAll() {
        CleanStatusBar.disable();
    }
    

    @Test
    public void testTakeMoreScreenshots() {

        Screengrab.screenshot("anotherActivity");
        onView(withId(R.id.fab)).perform(click()); // TODO: does not always finish displaying
        Screengrab.screenshot("anotherActivity-dialog");
    }
}