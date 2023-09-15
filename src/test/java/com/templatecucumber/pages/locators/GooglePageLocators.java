package com.templatecucumber.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GooglePageLocators {
    @FindBy(id = "APjFqb")
    public WebElement inputSearch;

    @FindBy(className = "a4bIc")
    public WebElement textInput;

    @FindBy(css = "h3")
    public List<WebElement> titleResults;

    @FindBy(css = "img[alt=Google]")
    public WebElement imgGoogle;
}
