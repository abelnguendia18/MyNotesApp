package com.tapondjou.mynotesapp;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Utils {



    public static AndroidDriver getDriver(String driverName, String PlatformName, String language, String locale) throws MalformedURLException{

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", PlatformName);
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("deviceName", "emulator-5554");
        //capabilities.setCapability("platformVersion", "12");
        //capabilities.setCapability(MobileCapabilityType.UDID, "897X06F1Q");
        capabilities.setCapability("automationName", driverName);
        capabilities.setCapability("app", "/Users/abelnguendiat./Documents/GitHub/MyNotesApp/app-debug.apk");
        capabilities.setCapability("appPackage", "com.tapondjou.mynotesapp");
        capabilities.setCapability("appActivity", "com.tapondjou.mynotesapp.MainActivity");
        capabilities.setCapability("language", language);
        capabilities.setCapability("locale", locale);
        URL url = new URL("http://192.168.0.199/wd/hub/");
        return new AndroidDriver(url, capabilities);

    }

    public static AndroidDriver getDriver(String driverName, String PlatformName) throws MalformedURLException{

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", PlatformName);
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("deviceName", "emulator-5554");
        //capabilities.setCapability("platformVersion", "12");
        //capabilities.setCapability(MobileCapabilityType.UDID, "897X06F1Q");
        capabilities.setCapability("automationName", driverName);
        capabilities.setCapability("app", "/Users/abelnguendiat./Documents/GitHub/MyNotesApp/app-debug.apk");
        capabilities.setCapability("appPackage", "com.tapondjou.mynotesapp");
        capabilities.setCapability("appActivity", "com.tapondjou.mynotesapp.MainActivity");
        URL url = new URL("http://192.168.0.199:4723/wd/hub/");
        return new AndroidDriver(url, capabilities);

    }

    //Find element by Text and ClassName
    public static WebElement selectClassNameWhereValueIsText(String text, String className, AndroidDriver driver) {

        String selector = "new UiSelector().text(\""+ text +"\").className(\""+ className +"\")";

        return driver.findElement(MobileBy.AndroidUIAutomator(selector));
    }


    public static void takesScreenshot(String screenshotName, String locale, AndroidDriver driver) throws IOException {
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("/Applications/MAMP/htdocs/screenshots/images/" + locale + "/" + screenshotName + ".png"));
    }

}
