package com.herokuapp.the_internet.dynamic_controls;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsWithExplicitWaitsTest {

    private final String URL = "https://the-internet.herokuapp.com/dynamic_controls";
    private WebDriver driver;

    @Test
    public void testDynamicLoadedMessageWithExplicitWait() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(URL);

        String CHECKBOX_EXAMPLE_BUTTON_LOCATOR = "//form[@id='checkbox-example']/button";
        driver.findElement(By.xpath(CHECKBOX_EXAMPLE_BUTTON_LOCATOR)).click();

        String MESSAGE_LOCATOR = "//p[@id='message']";
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MESSAGE_LOCATOR)));
        String actual = message.getText();

        Assertions.assertEquals("It's gone!", actual);
    }

    @Test
    public void testDynamicLoadedMessageWithCustomizedExplicitWait() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(URL);

        String CHECKBOX_EXAMPLE_BUTTON_LOCATOR = "//form[@id='checkbox-example']/button";
        driver.findElement(By.xpath(CHECKBOX_EXAMPLE_BUTTON_LOCATOR)).click();

        String MESSAGE_LOCATOR = "//p[@id='message']";
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(4))
                        .pollingEvery(Duration.ofMillis(500))
                        .ignoring(NoSuchElementException.class);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MESSAGE_LOCATOR)));
        String actual = message.getText();

        Assertions.assertEquals("It's gone!", actual);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
