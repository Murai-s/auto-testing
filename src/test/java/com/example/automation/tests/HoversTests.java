package com.example.automation.tests;

import com.example.automation.base.BaseTest;
import com.example.automation.config.TestConfig;
import com.example.automation.pages.HoversPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoversTests extends BaseTest {

    private HoversPage hoversPage;

    @BeforeMethod
    public void navigateToHoversPage() {
        driver.get(TestConfig.BASE_URL + "/hovers");
        hoversPage = new HoversPage(driver);
    }

    @Test
    public void testHoverOnUser1ShowsCaption() {
        hoversPage.hoverOverAvatar(0);
        WebElement firstAvatarCaption = hoversPage.getCaptionForAvatar(0);
        Assert.assertTrue(firstAvatarCaption.isDisplayed(), "Подпись для первого пользователя не появилась!");
        Assert.assertTrue(firstAvatarCaption.getText().contains("name: user1"), "Текст подписи для user1 неверный");;
    }

    @Test
    public void testHoverOnUser2ShowsCaption() {
        hoversPage.hoverOverAvatar(1);
        WebElement secondAvatarCaption = hoversPage.getCaptionForAvatar(1);
        Assert.assertTrue(secondAvatarCaption.isDisplayed(), "Подпись для второго аватара не появилась!");
        Assert.assertTrue(secondAvatarCaption.getText().contains("name: user2"), "Текст подписи для user2 неверный");
    }

}
