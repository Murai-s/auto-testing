package com.example.automation.tests;

import com.example.automation.base.BaseTest;
import com.example.automation.config.TestConfig;
import com.example.automation.pages.LoginPage;
import com.example.automation.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void navigateToLoginPage() {
        driver.get(TestConfig.BASE_URL + "/login");
    }

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);

        SecureAreaPage secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword!");

        String alertText = secureAreaPage.getStatusAlertText();
        Assert.assertTrue(alertText.contains("You logged into a secure area!"),
                "Текст сообщения об успехе неверный!");
    }
}
