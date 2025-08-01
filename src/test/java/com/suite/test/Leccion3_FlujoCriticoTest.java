package com.suite.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.suite.pages.RegisterPage;

public class Leccion3_FlujoCriticoTest extends BaseTest {

    private RegisterPage registerPage;

    @BeforeMethod
    public void init() {
        registerPage = new RegisterPage((WebDriver) driver);
        registerPage.open();
    }

    @Test(dataProvider = "registrationData", dataProviderClass = RegistrationDataProvider.class)
    public void testRegistration(String nombre, String correo, String pass, String confirm,
            String run, String childRun, boolean shouldPass, String descripcion) {

        registerPage.registerAs(nombre, correo, pass, confirm, run, childRun);

        // Espera hasta que la URL cambie o no
        boolean sigueEnRegistro;
        try {
            new WebDriverWait((WebDriver) driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.not(ExpectedConditions.urlContains("/register")));
            sigueEnRegistro = false; // URL cambió
        } catch (Exception e) {
            sigueEnRegistro = true; // Timeout, sigue en /register
        }

        if (shouldPass) {
            Assert.assertFalse(sigueEnRegistro, "Debería salir de la página de registro");
        } else {
            Assert.assertTrue(sigueEnRegistro, "Debería quedarse en la página de registro");
        }
    }
}
