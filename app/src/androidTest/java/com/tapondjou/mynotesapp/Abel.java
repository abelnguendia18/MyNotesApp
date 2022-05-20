package com.tapondjou.mynotesapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Abel {

    AndroidDriver driver;
    @Before
    public void setUp() throws MalformedURLException, InterruptedException {
        File app = new File("/Users/abelnguendiat./Desktop/app-release.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid","897X06F1Q");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        capabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability("app", "/Users/abelnguendiat./Desktop/app-debug.apk");
        //capabilities.setCapability("noSign", "true");
        capabilities.setCapability("appPackage", "com.tapondjou.mynotesapp");
        capabilities.setCapability("appActivity","com.tapondjou.mynotesapp.MainActivity");
        driver = new AndroidDriver(new URL("http://192.168.0.199:4723/wd/hub/"), capabilities);

        Thread.sleep(1000);

    }

    @Test
    public void oneTest(){

     //driver.findElementById("com.tapondjou.mynotesapp:id/fab").click();
        Assert.assertEquals(4, 2+2);

    }
}
