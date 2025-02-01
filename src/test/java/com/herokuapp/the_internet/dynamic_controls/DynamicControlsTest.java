package com.herokuapp.the_internet.dynamic_controls;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicControlsTest {

    private final String URL = "https://the-internet.herokuapp.com/dynamic_controls";
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        /**
         * Waiting Strategies
         * https://www.selenium.dev/documentation/webdriver/waits/
         * - Implicit waits
         * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
         */
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void testRemoveACheckbox() {
        DynamicControlsPage page = new DynamicControlsPage(driver);
        page.clickRemoveAddButton();

        String actual = page.getMessageText();
        Assertions.assertEquals("It's gone!", actual);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
