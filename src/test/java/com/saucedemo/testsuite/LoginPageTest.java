package com.saucedemo.testsuite;

import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.page.LoginPage;
import com.saucedemo.page.ProductPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        loginPage = new LoginPage();
        productPage = new ProductPage();
    }

    @Test (groups = {"Sanity","Regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginLink();
        String expectedMessage = "Products";
        String actualMessage = productPage.getProductsText();
        Assert.assertEquals(expectedMessage, actualMessage, "Products Page not displayed");
    }
}