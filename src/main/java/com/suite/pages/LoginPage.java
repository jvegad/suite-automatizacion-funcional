package com.suite.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By runInput = By.xpath("//input[@placeholder='Ingresa tu RUN']");
    private By passwordInput = By.xpath("//input[@placeholder='Ingresa tu ClaveÚnica']");
    private By loginButton = By.xpath("//button[text()='INGRESA']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void enterRun(String run) {
        driver.findElement(runInput).clear();
        driver.findElement(runInput).sendKeys(run);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void loginAs(String run, String password) {
        enterRun(run);
        enterPassword(password);
        clickLogin();
    }

    /**
     * Espera hasta que la URL deje de contener "/login". Devuelve true si
     * sucede dentro del timeout, false en caso contrario.
     */
    public boolean isLoginSuccessful() {
        try {
            wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("/login")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
