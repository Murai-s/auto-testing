package com.example.automation.tests;

import com.example.automation.base.BaseTest;
import com.example.automation.config.TestConfig;
import com.example.automation.pages.DynamicLoadingPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicLoadingTests extends BaseTest {

    private DynamicLoadingPage dynamicLoadingPage;

    @BeforeMethod
    public void navigateToDynamicLoadingPage() {
        driver.get(TestConfig.BASE_URL + "/dynamic_loading/2");
        dynamicLoadingPage = new DynamicLoadingPage(driver);
    }

    @Test
    public void testHelloWorldIsDisplayedAfterLoading() {
        dynamicLoadingPage.clickStartButton();

        String loadedText = dynamicLoadingPage.getLoadedText();
        Assert.assertEquals(loadedText, "Hello World!", "Загруженный текст неверный!");
    }
}
