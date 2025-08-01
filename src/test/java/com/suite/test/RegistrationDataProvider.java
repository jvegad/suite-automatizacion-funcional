package com.suite.test;

import java.util.Random;

import org.testng.annotations.DataProvider;

public class RegistrationDataProvider {

    // Genera correo único usando timestamp
    private static String uniqueEmail(String base) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        return base.toLowerCase().replace(" ", ".") + "+" + timestamp + "@mail.com";
    }

    // Genera RUT válido con verificador (sin puntos)
    private static String generateValidRut() {
        Random rand = new Random();
        int number = 1000000 + rand.nextInt(80000000); // entre 1M y 89M aprox
        char dv = calculateDV(number);
        return number + "-" + dv;
    }

    // Calcula dígito verificador del RUT
    private static char calculateDV(int rut) {
        int m = 0, s = 1;
        while (rut != 0) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
            rut /= 10;
        }
        return (char) (s != 0 ? s + 47 : 'K');
    }

    @DataProvider(name = "registrationData")
    public static Object[][] registrationData() {
        return new Object[][]{
            // Registro válido
            {"María Díaz", uniqueEmail("maria"), "Abc123!", "Abc123!", generateValidRut(), generateValidRut(), true, "registro exitoso"},
            // Contraseña insegura
            {"Ana Gómez", uniqueEmail("ana"), "123", "123", generateValidRut(), generateValidRut(), false, "contraseña insegura"},
            // Contraseñas no coinciden
            {"Luis Soto", uniqueEmail("luis"), "Abc123!", "Xyz987!", generateValidRut(), generateValidRut(), false, "no coinciden"},
            // Email inválido
            {"Pedro Muñoz", "correo_invalido", "Abc123!", "Abc123!", generateValidRut(), generateValidRut(), false, "email inválido"}
        };
    }
}
