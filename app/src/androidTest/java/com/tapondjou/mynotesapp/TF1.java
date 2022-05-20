package com.tapondjou.mynotesapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;

public class TF1 {

    AndroidDriver driver;

    @Test
    public void createNoteTest() throws InterruptedException, MalformedURLException {

        driver = Utils.getDriver("UiAutomator2", "Android");
        String TITLE_TO_ENTER = "Title 2";
        String DESCRIPTION_TO_ENTER = "Description 2";

        //Wait for the items to load on the screen
        Thread.sleep(1000);

        //Click on the add note button
        driver.findElement(By.id("com.tapondjou.mynotesapp:id/fab")).click();

        //Wait for the items to load on the screen
        Thread.sleep(1000);

        //Enter note's title and description
        WebElement element = driver.findElement(By.id("com.tapondjou.mynotesapp:id/edt_note_title"));
        element.clear();
        element.click();
        element.sendKeys(TITLE_TO_ENTER);
        //driver.findElement(By.id("com.tapondjou.mynotesapp:id/edt_note_description").sendKeys(DESCRIPTION_TO_ENTER));

        //Save the note
        driver.findElement(By.id("com.tapondjou.mynotesapp:id/button_create_note")).click();
        Thread.sleep(1000);

        //Verify that the note is displayed on screen
        Utils.selectClassNameWhereValueIsText(TITLE_TO_ENTER, Constants.TEXT_VIEW_CLASS_NAME, driver).isDisplayed();
        Utils.selectClassNameWhereValueIsText(DESCRIPTION_TO_ENTER, Constants.TEXT_VIEW_CLASS_NAME, driver).isDisplayed();

    }







    @After
    public void tearDown() {

        driver.quit();

    }



}