package com.example.automation.tests;

import com.example.automation.base.BaseTest;
import com.example.automation.config.TestConfig;
import com.example.automation.pages.AddRemoveElementsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddRemoveButtonsTests extends BaseTest {

    private AddRemoveElementsPage addRemoveElementsPage;

    @BeforeMethod
    public void navigateToAddRemoveButtonsPage() {
        driver.get(TestConfig.BASE_URL + "/add_remove_elements/");
        addRemoveElementsPage = new AddRemoveElementsPage(driver);
    }

    @Test
    public void testAddAndRemoveButtonsCycle() {
        Assert.assertEquals(addRemoveElementsPage.getNumberOfDeleteButtons(), 0, "Изначально кнопок 'Delete' быть не должно");

        addRemoveElementsPage.clickAddElementButton();
        Assert.assertEquals(addRemoveElementsPage.getNumberOfDeleteButtons(), 1, "После первого клика должна появиться только одна кнопка 'Delete'!");

        addRemoveElementsPage.clickAddElementButton();
        Assert.assertEquals(addRemoveElementsPage.getNumberOfDeleteButtons(), 2, "После первого клика должно быть только две кнопки 'Delete'!");

        addRemoveElementsPage.clickFirstDeleteElementButton();
        Assert.assertEquals(addRemoveElementsPage.getNumberOfDeleteButtons(), 1, "После удаления должна остаться одна кнопка 'Delete'");

    }
}
