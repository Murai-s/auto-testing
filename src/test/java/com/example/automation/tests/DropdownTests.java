package com.example.automation.tests;

import com.example.automation.base.BaseTest;
import com.example.automation.config.TestConfig;
import com.example.automation.pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTests extends BaseTest {

    private DropdownPage dropdownPage;

    @BeforeMethod
    public void navigateToDropdownPage() {
        driver.get(TestConfig.BASE_URL + "/dropdown");
        dropdownPage = new DropdownPage(driver);
    }

    @Test
    public void testDropdownSelection() {
        dropdownPage.selectOptionByText("Option 1");

        String selectedText = dropdownPage.getSelectedOptionText();
        Assert.assertEquals(selectedText, "Option 1");
    }
}
