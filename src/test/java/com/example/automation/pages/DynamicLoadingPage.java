package com.example.automation.pages;

import com.example.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicLoadingPage extends BasePage {

    private final By startButton = By.cssSelector("#start button");
    private final By finishText = By.id("finish");

    public DynamicLoadingPage(WebDriver driver) {
       super(driver);
    }

    public void clickStartButton() {
        waitAndClick(startButton);
    }

    public String getLoadedText() {
        return waitAndGetText(finishText);
    }
}
