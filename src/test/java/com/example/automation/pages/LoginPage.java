package com.example.automation.pages;

import com.example.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        waitAndSendKeys(usernameField, username);
    }

    public void enterPassword(String password) {
        waitAndSendKeys(passwordField, password);
    }

    public SecureAreaPage clickLoginButton() {
        waitAndClick(loginButton);

        return new SecureAreaPage(driver);
    }

    public SecureAreaPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);

        return clickLoginButton();
    }


}
