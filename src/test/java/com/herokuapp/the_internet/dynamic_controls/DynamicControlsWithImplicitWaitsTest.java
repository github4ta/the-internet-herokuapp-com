package com.herokuapp.the_internet.dynamic_controls;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DynamicControlsWithImplicitWaitsTest {

    private final String URL = "https://the-internet.herokuapp.com/dynamic_controls";
    private WebDriver driver;

    @Test
    public void testDynamicLoadedMessageWithDriverMethodImplicitWait() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();

        driver.get(URL);

        String CHECKBOX_EXAMPLE_BUTTON_LOCATOR = "//form[@id='checkbox-example']/button";
        driver.findElement(By.xpath(CHECKBOX_EXAMPLE_BUTTON_LOCATOR)).click();

        String MESSAGE_LOCATOR = "//p[@id='message']";
        String actual = driver.findElement(By.xpath(MESSAGE_LOCATOR)).getText();

        Assertions.assertEquals("It's gone!", actual);
    }

    @Test
    public void testDynamicLoadedMessageWithChromeOptionsImplicitWait() {
        ChromeOptions chromeOptions = new ChromeOptions();
        Duration duration = Duration.of(4, ChronoUnit.SECONDS);
        chromeOptions.setImplicitWaitTimeout(duration);

        driver = new ChromeDriver(chromeOptions);
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
