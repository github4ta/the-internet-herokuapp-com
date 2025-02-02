package com.herokuapp.the_internet.dynamic_controls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicControlsTest {

    @Test
    public void testPageOpened() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        String dynamicControlsLinkXpath = "//a[@href='/dynamic_controls']";
        By dynamicControlsLinkBy = By.xpath(dynamicControlsLinkXpath);
        WebElement dynamicControlsLink = driver.findElement(dynamicControlsLinkBy);
        dynamicControlsLink.click();

        String dynamicControlsTitleXpath = "//h4[1]";
        By dynamicControlsTitleBy = By.xpath(dynamicControlsTitleXpath);
        WebElement dynamicControlsTitle = driver.findElement(dynamicControlsTitleBy);
        String actual = dynamicControlsTitle.getText();

        Assertions.assertEquals("Dynamic Controls", actual);
    }

    @Test
    public void testThatMessageIsVisibleWhenUserClicksRemoveButton() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        String removeButtonXpath = "//form[@id='checkbox-example']/button";
        By removeButtonBy = By.xpath(removeButtonXpath);
        WebElement removeButton = driver.findElement(removeButtonBy);
        removeButton.click();

        String messageXpath = "//p[@id='message']";
        By messageBy = By.xpath(messageXpath);
        WebElement message = driver.findElement(messageBy);
        String actual = message.getText();

        Assertions.assertEquals("It's gone!", actual);
    }
}
