package com.example.automation.pages;

import com.example.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicAuthPage extends BasePage {

    private final By successMessage = By.xpath("//*[@id='content']/div/p");

    public BasicAuthPage(WebDriver driver) {
        super(driver);
    }

    public String getCongratulationsMessageText() {
        return waitAndGetText(successMessage);
    }
}
