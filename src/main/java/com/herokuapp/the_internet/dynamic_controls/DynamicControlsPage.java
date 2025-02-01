package com.herokuapp.the_internet.dynamic_controls;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsPage {

    private static boolean isClickedCheckboxExampleButton = false;

    private final int DEFAULT_DURATION_OF_SECONDS = 4;

    private final String CHECKBOX_EXAMPLE_BUTTON_LOCATOR = "//form[@id='checkbox-example']/button";
    private final String MESSAGE_LOCATOR = "//p[@id='message']";

    private WebDriver driver;

    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRemoveAddButton() {
        if (!isClickedCheckboxExampleButton) {
            isClickedCheckboxExampleButton = true;
        }
        driver.findElement(By.xpath(CHECKBOX_EXAMPLE_BUTTON_LOCATOR)).click();
    }

    public String getMessageText() {
        /**
         * Waiting Strategies
         * https://www.selenium.dev/documentation/webdriver/waits/
         * - Explicit waits
         * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_DURATION_OF_SECONDS));
         * WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MESSAGE_LOCATOR)));
         */
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_DURATION_OF_SECONDS));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MESSAGE_LOCATOR)));
        return message.getText();

        /**
         * Waiting Strategies
         * https://www.selenium.dev/documentation/webdriver/waits/
         * - Explicit waits
         * Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_DURATION_OF_SECONDS));
         * wait.until(d -> driver.findElement(By.xpath(MESSAGE_LOCATOR)).isDisplayed());
         */
        /*
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_DURATION_OF_SECONDS));
        wait.until(d -> driver.findElement(By.xpath(MESSAGE_LOCATOR)).isDisplayed());
        */

        /**
         * Waiting Strategies
         * https://www.selenium.dev/documentation/webdriver/waits/
         * - Explicit waits
         * - Customization
         * - Fluent wait
         * Wait<WebDriver> wait =
         *        new FluentWait<>(driver)
         *                .withTimeout(Duration.ofSeconds(4))
         *                .pollingEvery(Duration.ofMillis(500))
         *                .ignoring(NoSuchElementException.class);
         *
         * WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MESSAGE_LOCATOR)));
         *
         * wait.until(d -> driver.findElement(By.xpath(MESSAGE_LOCATOR)).isDisplayed());
         */
        /*
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(4))
                        .pollingEvery(Duration.ofMillis(500))
                        .ignoring(NoSuchElementException.class);

        wait.until(d -> driver.findElement(By.xpath(MESSAGE_LOCATOR)).isDisplayed());

        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MESSAGE_LOCATOR)));
        return message.getText();
        */

        // return driver.findElement(By.xpath(MESSAGE_LOCATOR)).getText();
    }
}
