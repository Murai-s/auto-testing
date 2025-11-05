package com.example.automation.pages;

import com.example.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoversPage extends BasePage {

    private final By userAvatars = By.className("figure");
    private final By userCaptions = By.className("figcaption");

    public HoversPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOverAvatar(int index) {
        List<WebElement> avatars = driver.findElements(userAvatars);
        WebElement targetAvatar = avatars.get(index);

        Actions actions = new Actions(driver);
        actions.moveToElement(targetAvatar).perform();
    }

    public WebElement getCaptionForAvatar(int index) {
        List<WebElement> captions = driver.findElements(userCaptions);
        return captions.get(index);
    }





}
