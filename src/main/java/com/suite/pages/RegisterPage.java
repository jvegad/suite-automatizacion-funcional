package com.suite.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By nameInput = By.xpath("//input[@placeholder='Nombre completo']");
    private By emailInput = By.xpath("//input[@placeholder='Correo electrónico']");
    private By passwordInput = By.xpath("//input[@placeholder='Contraseña']");
    private By confirmInput = By.xpath("//input[@placeholder='Confirmar contraseña']");
    private By runInput = By.xpath("//input[@placeholder='RUT']");
    private By childRunInput = By.xpath("//input[@placeholder='RUT Carga']");
    private By registerButton = By.xpath("//button[text()='Registrar']");
    private By errorMessages = By.cssSelector("span.error");

    // Modal de condiciones de uso
    private By acceptButtonInModal = By.xpath("//button[text()='Acepto']");
    private By modalBox = By.xpath("//div[contains(@class, 'shadow-lg') and .//h2[contains(text(),'Condiciones de Uso')]]");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://mi-carnet-infantil.web.app/register");
    }

    private void acceptTermsIfPresent() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(modalBox));
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(acceptButtonInModal));
            acceptButton.click();
            // Asegurarse de que el modal desaparece
            wait.until(ExpectedConditions.invisibilityOfElementLocated(modalBox));
        } catch (Exception e) {
            // Si no aparece el modal, continúa sin fallo
        }
    }

    public void fillName(String name) {
        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);
    }

    public void fillEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillPassword(String pwd) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(pwd);
    }

    public void fillConfirm(String pwd) {
        driver.findElement(confirmInput).clear();
        driver.findElement(confirmInput).sendKeys(pwd);
    }

    public void fillRun(String run) {
        driver.findElement(runInput).clear();
        driver.findElement(runInput).sendKeys(run);
    }

    public void fillChildRun(String run) {
        driver.findElement(childRunInput).clear();
        driver.findElement(childRunInput).sendKeys(run);
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public String[] getErrorMessages() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(errorMessages));
        return driver.findElements(errorMessages)
                .stream()
                .map(WebElement::getText)
                .toArray(String[]::new);
    }

    public void registerAs(String name, String email,
            String pwd, String confirm,
            String run, String childRun) {
        acceptTermsIfPresent();
        fillName(name);
        fillEmail(email);
        fillPassword(pwd);
        fillConfirm(confirm);
        fillRun(run);
        fillChildRun(childRun);
        clickRegister();
    }
}
