# Reporte Módulo 4: Suite de Automatización Funcional

## 1. Integrantes y Distribución de Tareas

*   **Josselyn Vega** (GitHub: [jvegad](https://github.com/jvegad))
    *   *Responsable de Lecciones 1 y 2, integración completa del proyecto, y elaboración del reporte final.*
*   **Viki Borda** (GitHub: [McKingston01](https://github.com/McKingston01))
    *   *Responsable de Lecciones 3 a 7, implementando la arquitectura POM y las pruebas parametrizadas.*
    
---

## 2. Resumen del Proyecto

Este repositorio contiene una suite de pruebas de automatización funcional para una aplicación web. El objetivo principal es validar los flujos críticos de **registro de usuario** y **login**, asegurando la calidad y estabilidad del software ante distintos escenarios de datos.

El proyecto está construido en **Java** y gestionado con **Maven**, utilizando **TestNG** como framework de ejecución. Se ha implementado el patrón de diseño **Page Object Model (POM)** para crear un código robusto, mantenible y escalable.

La suite incluye funcionalidades avanzadas como:
*   Pruebas parametrizadas con **DataProvider**.
*   Ejecución **Cross-Browser** (Chrome y Firefox).
*   Generación automática de **capturas de pantalla** en caso de fallo en las pruebas.
*   Reportes de ejecución detallados a través de Maven Surefire.

*   **Tecnologías Utilizadas:**
    *   **Lenguaje:** Java 17+
    *   **Gestión de Dependencias:** Apache Maven
    *   **Framework de Pruebas:** TestNG
    *   **Automatización Web:** Selenium WebDriver
    *   **Gestión de Drivers:** WebDriverManager
    *   **Patrón de Diseño:** Page Object Model (POM)

---

## 3. Instrucciones de Configuración y Ejecución

A continuación se detallan los pasos para clonar, compilar y probar el proyecto.

### Prerrequisitos
*   JDK 17 (o compatible) instalado.
*   Apache Maven instalado y configurado en el `PATH` del sistema.
*   Git instalado.

### Pasos para la Ejecución

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/jvegad/suite-automatizacion-funcional
    cd suite-automatizacion-funcional
    ```

2.  **Compilar y ejecutar las pruebas:**
    El siguiente comando limpiará compilaciones anteriores, compilará el código y ejecutará la suite de pruebas definida en `testing.xml`.
    ```bash
    mvn clean test
    ```
    Al finalizar, deberías ver un `BUILD SUCCESS` en la consola.

---

## 4. Evidencias de Ejecución

*   📋 **[Ver Capturas (Screenshots)](https://github.com/jvegad/suite-automatizacion-funcional/tree/main/screenshots)**
    *   *Enlace a la carpeta de PNGs con capturas de los errores.*

*   🎥 **[Ver Video: Ejecución Completa Exitosa](https://youtu.be/DcSRxfhrPYo)**
    *   *Muestra la ejecución completa de la suite de pruebas, finalizando con éxito.*

*   🎥 **[Ver Video: Ejecución con Fallo y Captura de Pantalla](https://youtu.be/8VZ2kx5eRtA)**
    *   *Demuestra cómo el `TestListener` captura una pantalla automáticamente cuando una aserción falla.*

*   📋 **[Ver Reporte de Pruebas (Surefire)](target/surefire-reports/index.html)**
    *   *Enlace al reporte HTML generado por Maven. Para verlo, primero ejecuta `mvn clean test` y luego abre este archivo en tu navegador.*

---

## 5. Desarrollo del Proyecto por Lecciones

El proyecto se desarrolló de forma colaborativa, integrando las contribuciones de ambas participantes en una única suite de pruebas funcional.

### Lección 1 y 2: Configuración Inicial y Prototipado 
Se realizó la configuración inicial del proyecto Maven, la estructura de carpetas y la grabación de los flujos iniciales de Registro y Login utilizando **Katalon Recorder**. Estos scripts exportados sirvieron como base para la automatización manual.

*   **Clases de prueba:** `Leccion1_ValidacionInicialTest.java`, `Leccion2_SeleniumIDETest.java`
*   **Evidencia de scripts:** Se encuentran en `src/test/resources/scriptsExportados/`

### Lección 3: Automatización de Flujos Críticos 
Se implementó la prueba automatizada para el flujo de registro, cubriendo múltiples escenarios mediante un DataProvider.

*   **Clase de prueba:** `Leccion3_FlujoCriticoTest.java`
*   **DataProvider:** `RegistrationDataProvider.java`

### Lección 4: Interacción con Elementos Web 
La implementación del Page Object Model demuestra el uso de diversas estrategias de localización (`By.xpath`, `By.cssSelector`) y esperas explícitas (`WebDriverWait`) para garantizar una interacción estable con los elementos web.

*   **Evidencia:** Clases en el paquete `com.suite.pages`.

### Lección 5: Evidencias y Estructura POM 
Se implementó y aplicó el patrón **Page Object Model (POM)** para organizar el código. Además, se configuró un `TestListener` para tomar **capturas de pantalla automáticamente** en cada fallo.

*   **Estructura POM:** `HomePage`, `LoginPage`, `RegisterPage`.
*   **Captura de Pantallas:** `TestListener.java`.

### Lección 6: Ejecución Cross-Browser 
La clase `BaseTest.java` fue configurada para permitir la ejecución de pruebas en múltiples navegadores (Chrome y Firefox), controlada a través de parámetros en el archivo `testing.xml`.

*   **Evidencia:** `BaseTest.java` y `testing.xml`.

### Lección 7: Pruebas con Múltiples Datos 
Se implementó una prueba de login data-driven, que lee múltiples combinaciones de credenciales desde un `DataProvider` para validar los resultados esperados.

*   **Clase de prueba:** `Leccion7_MultiplesDatosTest.java`
*   **DataProvider:** `DataProviderClass.java`
