package com.example.automation.tests;

import com.example.automation.base.BaseTest;
import com.example.automation.config.TestConfig;
import com.example.automation.pages.CheckBoxesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxesTests extends BaseTest {

    private CheckBoxesPage checkBoxesPage;

    @BeforeMethod
    public void navigateToCheckBoxPage() {
        driver.get(TestConfig.BASE_URL + "/checkboxes");
        checkBoxesPage = new CheckBoxesPage(driver);
    }

    @Test
    public void checkCheckBoxSetting() {
        Assert.assertFalse(checkBoxesPage.isFirstCheckBoxSelected(), "Первый чекбокс отмечен!");
        checkBoxesPage.clickFirstCheckBox();
        Assert.assertTrue(checkBoxesPage.isFirstCheckBoxSelected(), "Первый чекбокс не отмечен!");
    }

    @Test
    public void checkCheckBoxUnsetting() {
        Assert.assertTrue(checkBoxesPage.isSecondCheckBoxSelected(), "Второй чекбокс должен быть отмечен!");
        checkBoxesPage.clickSecondCheckBox();
        Assert.assertFalse(checkBoxesPage.isSecondCheckBoxSelected(), "Второй чекбокс должен быть не отмечен!");
    }
}
