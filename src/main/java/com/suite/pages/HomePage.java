package com.suite.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriverWait wait;

    // Selector del botón "Cerrar sesión" que solo existe tras login
    private By logoutButton = By.xpath("//button[text()='Cerrar sesión']");

    public HomePage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    /**
     * Espera hasta que el botón de "Cerrar sesión" sea visible.
     *
     * @return true si aparece dentro del timeout (login exitoso), false de lo
     * contrario.
     */
    public boolean isAt() {
        try {
            // Espera y captura el elemento para usar driver en la validación
            WebElement button = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(logoutButton)
            );
            return button.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
