package com.example.automation.pages;

import com.example.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    private final By dropdownList = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void selectOptionByText(String optionText) {
        Select dropdown = getDropdownSelect();
        dropdown.selectByVisibleText(optionText);
    }

    public String getSelectedOptionText() {
        Select dropdown = getDropdownSelect();
        WebElement selectedElement = dropdown.getFirstSelectedOption();
        return selectedElement.getText();
    }

    private Select getDropdownSelect() {
        WebElement dropdownElement = findVisibleElement(dropdownList);
        return new Select(dropdownElement);
    }
}
