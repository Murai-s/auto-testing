package com.example.automation.pages;

import com.example.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRemoveElementsPage extends BasePage {

    private final By addElementButton = By.xpath("//button[text()='Add Element']");
    private final By deleteElementButtons = By.className("added-manually");

    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddElementButton() {
        waitAndClick(addElementButton);
    }

    public int getNumberOfDeleteButtons() {
        return driver.findElements(deleteElementButtons).size();
    }

    public void clickFirstDeleteElementButton() {
        waitForListOfElements(deleteElementButtons).getFirst().click();
    }


}
