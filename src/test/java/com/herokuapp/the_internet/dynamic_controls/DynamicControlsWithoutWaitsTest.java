package com.herokuapp.the_internet.dynamic_controls;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DynamicControlsWithoutWaitsTest {

    private final String URL = "https://the-internet.herokuapp.com/dynamic_controls";
    private WebDriver driver;

    @Test
    public void testDynamicLoadedMessageWithoutWait() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(URL);

        String CHECKBOX_EXAMPLE_BUTTON_LOCATOR = "//form[@id='checkbox-example']/button";
        driver.findElement(By.xpath(CHECKBOX_EXAMPLE_BUTTON_LOCATOR)).click();

        String MESSAGE_LOCATOR = "//p[@id='message']";
        String actual = driver.findElement(By.xpath(MESSAGE_LOCATOR)).getText();

        Assertions.assertEquals("It's gone!", actual);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
