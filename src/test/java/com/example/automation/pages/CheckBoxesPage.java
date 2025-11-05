package com.example.automation.pages;

import com.example.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxesPage extends BasePage {

    private final By firstCheckBox = By.xpath("//form[@id='checkboxes']/input[1]");
    private final By secondCheckBox = By.xpath("//form[@id='checkboxes']/input[2]");

    public CheckBoxesPage(WebDriver driver) {
        super(driver);
    }

    public void clickFirstCheckBox() {
        waitAndClick(firstCheckBox);
    }

    public boolean isFirstCheckBoxSelected() {
        return driver.findElement(firstCheckBox).isSelected();
    }

    public void clickSecondCheckBox() {
        waitAndClick(secondCheckBox);
    }

    public boolean isSecondCheckBoxSelected() {
        return driver.findElement(secondCheckBox).isSelected();
    }
}
