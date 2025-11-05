package com.example.automation.tests;

import com.example.automation.base.BaseTest;
import com.example.automation.pages.BasicAuthPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAuthTests extends BaseTest {

    private BasicAuthPage basicAuthPage;

    @BeforeMethod
    public void navigateToBasicAuthPage() {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        basicAuthPage = new BasicAuthPage(driver);
    }

    @Test
    public void testSuccessMessageAfterSuccessfulLogin() {
        String successMessage = basicAuthPage.getCongratulationsMessageText();
        Assert.assertTrue(successMessage.contains("Congratulations! You must have the proper credentials."));
    }
}
