package com.example.automation.base;

import com.example.automation.config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TestConfig.DEFAULT_WAIT_SECONDS));
    }

    protected WebElement findVisibleElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitAndClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void waitAndSendKeys(By locator, String text) {
        WebElement inputField = findVisibleElement(locator);
        inputField.clear();
        inputField.sendKeys(text);
    }

    protected String waitAndGetText(By locator) {
        WebElement element = findVisibleElement(locator);

        return element.getText();
    }

    protected List<WebElement> waitForListOfElements(By locator) {
        return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
    }

}
