package com.saucedemo.page;


import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(id = "user-name")
    WebElement usernameField;

    public void enterUsername(String userName) throws InterruptedException {
        Reporter.log("Enter User Name" + usernameField.toString());
        CustomListeners.test.log(Status.PASS, "Enter User Name");
        Thread.sleep(1000);
        sendTextToElement(usernameField, userName);
    }

    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;

    public void enterPassword(String password) throws InterruptedException {
        Reporter.log("Enter Password" + passwordField.toString());
        CustomListeners.test.log(Status.PASS, "Enter Password");
        Thread.sleep(1000);
        sendTextToElement(passwordField, password);
    }

    @CacheLookup
    @FindBy(id = "login-button")
    WebElement loginLink;

    public void clickOnLoginLink() {
        Reporter.log("Click On Login Link" + loginLink.toString());
        CustomListeners.test.log(Status.PASS, "Click On Login Link");
        clickOnElement(loginLink);
    }
}
