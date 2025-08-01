package com.suite.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.suite.pages.HomePage;
import com.suite.pages.LoginPage;

public class Leccion7_MultiplesDatosTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderClass.class)
    public void testLogin(String run, String password, boolean shouldSucceed) {
        LoginPage loginPage = new LoginPage((WebDriver) driver);
        loginPage.loginAs(run, password);

        HomePage homePage = new HomePage((WebDriver) driver);
        boolean loginSuccessful = homePage.isAt();

        if (shouldSucceed) {
            Assert.assertTrue(loginSuccessful, "El login debería ser exitoso para " + run);
        } else {
            Assert.assertFalse(loginSuccessful, "El login NO debería ser exitoso para " + run);
        }
    }
}
