package com.suite.test;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
            // ahora tienes el RUN ya con puntos y guion
            {"12.345.678-9", "user1234", true}, // válido
            {"12.345.678-9", "wrongpass", false}, // contraseña incorrecta
        //{"12.345.678-9", "", false},           // sin password
        // {"", "user1234", false},               // sin RUN
        //{"", "", false},                       // ambos vacíos
        //{"12.345.678-0", "fake123", false}     // RUN inválido
        };
    }
}
