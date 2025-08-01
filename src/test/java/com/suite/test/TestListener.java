package com.suite.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("ERROR: La prueba '" + result.getName() + "' ha fallado.");

        // Intenta obtener la instancia del WebDriver de forma segura
        WebDriver driver = null;
        Object testInstance = result.getInstance();

        try {
            // Usamos "reflexión" para buscar un campo llamado "driver" en la clase de prueba
            // Esto funciona para CUALQUIER clase que tenga una variable "private WebDriver driver;"
            driver = (WebDriver) testInstance.getClass().getDeclaredField("driver").get(testInstance);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
            System.err.println("No se pudo obtener el driver de la clase de prueba para tomar la captura. Error: " + e.getMessage());
            return;
        }

        // Si el driver existe, toma la captura
        if (driver != null) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "screenshots/" + result.getName() + "_" + System.currentTimeMillis() + ".png";
            File destFile = new File(screenshotPath);
            try {
                FileUtils.copyFile(screenshotFile, destFile);
                System.out.println("Captura de pantalla guardada en: " + destFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
