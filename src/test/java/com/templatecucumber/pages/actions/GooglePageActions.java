package com.templatecucumber.pages.actions;

import com.templatecucumber.pages.locators.GooglePageLocators;
import com.templatecucumber.core.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GooglePageActions {
    Actions actions = null;
    GooglePageLocators googlePageLocators = null;
    WebDriverWait wait = null;

    public GooglePageActions(){
        this.googlePageLocators = new GooglePageLocators();
        PageFactory.initElements(DriverManager.getDriver(), googlePageLocators);
        this.wait =  new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        this.actions =  new Actions(DriverManager.getDriver());
    }

    public void sendKeysSearchField(String txtSearch){
        googlePageLocators.inputSearch.sendKeys(txtSearch + Keys.RETURN);
    }
    public String getTextSearchField(){
        return googlePageLocators.textInput.getText();
    }

    public String getFirstResult(){
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(googlePageLocators.titleResults.get(0)));
        return firstResult.getText();
    }

    public Boolean verifyImg(){
        return googlePageLocators.imgGoogle.isDisplayed();
    }
}
