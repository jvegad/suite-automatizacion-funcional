package com.suite.test; 

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Leccion1_ValidacionInicialTest {

    private WebDriver driver;

    // Esto se ejecuta ANTES de cada método de prueba (@Test)
    @BeforeMethod
    public void setUp() {
        // Configura y descarga automáticamente el driver para Chrome
        WebDriverManager.chromedriver().setup();
        // Crea una nueva instancia del navegador Chrome
        driver = new ChromeDriver();
        System.out.println("Navegador Chrome iniciado.");
    }

    // Este es nuestro primer caso de prueba
    @Test(description = "Validar que el título de la página de Google sea correcto")
    public void validarTituloDeGoogle() {
        System.out.println("Iniciando prueba: validarTituloDeGoogle");
        // 1. Navegar a la página web
        driver.get("https://www.google.com");

        // 2. Obtener el título actual de la página
        String tituloActual = driver.getTitle();
        String tituloEsperado = "Google";

        // 3. Validar que el título es el esperado
        // Assert.assertEquals comprueba si dos valores son iguales. Si no lo son, la prueba falla.
        Assert.assertEquals(tituloActual, tituloEsperado, "El título de la página no era el esperado.");
        System.out.println("Prueba finalizada con éxito. El título es '" + tituloActual + "'.");
    }

    // Esto se ejecuta DESPUÉS de cada método de prueba (@Test)
    @AfterMethod
    public void tearDown() {
        // Cierra el navegador y termina la sesión para limpiar recursos
        if (driver != null) {
            driver.quit();
            System.out.println("Navegador cerrado.");
        }
    }
}