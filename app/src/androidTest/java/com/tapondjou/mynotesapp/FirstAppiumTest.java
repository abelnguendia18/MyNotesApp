package com.tapondjou.mynotesapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class FirstAppiumTest {


    AndroidDriver driver;
    @Before
    public void setUp() throws MalformedURLException {
        File app = new File("/Users/abelnguendiat./Documents/GitHub/MyNotesApp/app-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("avd","Pixel_3a_API_30");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.zelfi.champion");
        capabilities.setCapability("appActivity","com.zelfi.champion.main.MainActivity_");
        driver = new AndroidDriver(new URL("http://192.168.0.199:4723/wd/hub/"), capabilities);

    }

    @Test
    public void oneTest(){

        Assert.assertEquals(4, 2+2);
        //driver.findElement(By.id(""));
    }
}
