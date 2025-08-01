# Reporte Módulo 4: Suite Automatización Funcional

## Integrantes
*   **Viki Borda** (GitHub: McKingston01)
*   **Josselyn Vega** (GitHub: jvegad)

---

## 1. Resumen del Proyecto

<Pendiente>

*   **Tecnologías Utilizadas:**
    *   **Lenguaje:** Java (Versión 24)
    *   **Gestión de Dependencias:** Apache Maven
    *   **Framework de Pruebas:** JUnit 5

---

## 2. Instrucciones de Configuración y Ejecución

A continuación se detallan los pasos para clonar, compilar y probar el proyecto.

### Prerrequisitos
*   JDK 24 (o compatible) instalado.
*   Apache Maven instalado y configurado en el PATH del sistema.
*   Git instalado.

### Pasos para la Ejecución

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/jvegad/suite-automatizacion-funcional
    cd suite-automatizacion-funcional
    ```

2.  **Compilar y ejecutar las pruebas:**
    El siguiente comando limpiará compilaciones anteriores, compilará el código y ejecutará todas las pruebas unitarias.
    ```bash
    mvn clean test
    ```
    Al finalizar, deberías ver un `BUILD SUCCESS` en la consola.

---

## 3. Desarrollo del Proyecto (Paso a Paso)

A continuación se describe el progreso por cada lección del módulo.
**Josselyn Vega**: encargada de Lecciones 1 y 2 e integración del proyecto
**Viki Borda**: encargada de lecciones 3 a 7

### Lección 1: Testing Funcional con Selenium 

*   **Objetivo:** Comprender los fundamentos de Selenium y validar la instalación del entorno.
*   **Métricas Cumplidas:**
    *   `[X]` **1 prueba ejecutada:** Se realiza 1 prueba ejecutada con éxito.
*   **Resultado:** Esta sección fue completada por la compañera de equipo.

---

### Lección 2: Prototipado con Selenium IDE 

*   **Objetivo:** Capturar flujos básicos de forma rápida utilizando una herramienta de grabación y reproducción para futuras pruebas detalladas.

*   **Métricas Cumplidas:**
    *   `[X]` **2 scripts grabados:** Se grabaron los flujos de **Registro de Usuario** y **Login de Usuario**.
    *   `[X]` **Exportación a código Java:** Ambos flujos fueron exportados a código Java utilizando el formato **TestNG**.
    *   `[X]` **Navegador:** Firefox

*   **Herramienta Utilizada:**
    *   Se utilizó **Katalon Recorder** para grabar las interacciones del usuario en el sitio de práctica [automationexercise.com](https://www.automationexercise.com/).

*   **Proceso Realizado:**
    1.  **Grabación del Flujo de Registro:** Se registraron los pasos para crear una nueva cuenta de usuario, llenando los campos obligatorios del formulario.
    2.  **Grabación del Flujo de Login:** Se grabó un segundo test para iniciar sesión con las credenciales creadas previamente.
    3.  **Exportación y Almacenamiento:** Los scripts generados por la herramienta fueron exportados y almacenados en el directorio `src/test/resources/scriptsExportados` como evidencia y para su posterior refactorización en lecciones futuras.
    4.  **Refactorización Inicial:** Los scripts exportados se unificaron y adaptaron en una única clase de prueba (`Leccion2_SeleniumIDETest.java`) para validar su correcta ejecución inicial.

*   **Evidencia:**
    *   Los scripts originales exportados se encuentran en la carpeta `src/test/resources/scriptsExportados/`.
    *   La clase de prueba funcional se encuentra en `src/test/java/com/suite/test/Leccion2_SeleniumIDETest.java`.

---
### Lección 3: Automatización de Flujos Críticos (Clase: `Leccion3_FlujoCriticoTest.java`)
*   **Objetivo:** Validar los flujos de registro y login ante distintos escenarios.
*   **Métricas Cumplidas:** Se automatizaron 4 escenarios de registro utilizando un DataProvider (`RegistrationDataProvider.java`), cubriendo casos de éxito, contraseña insegura, contraseñas no coincidentes y email inválido.

### Lección 4: Interacción con Elementos Web
*   **Objetivo:** Dominar la interacción con distintos tipos de elementos y su sincronización.
*   **Evidencia:** La implementación del Page Object Model en las clases `LoginPage.java` y `RegisterPage.java` demuestra el uso de múltiples localizadores (`By.xpath`, `By.cssSelector`) y esperas explícitas (`WebDriverWait`) para interactuar de forma robusta con la aplicación.

### Lección 5: Evidencias y Estructura POM
*   **Objetivo:** Organizar el código bajo el patrón POM y capturar resultados de ejecución.
*   **Métricas Cumplidas:**
    *   `[X]` **Estructura POM:** Se implementaron 3 clases de página (`HomePage`, `LoginPage`, `RegisterPage`) que encapsulan la lógica de interacción.
    *   `[X]` **Captura de Pantallas:** Se implementó un `TestListener` (`TestListener.java`) que toma una captura de pantalla automáticamente cada vez que una prueba falla, guardándola en la carpeta `/screenshots`.

### Lección 6: Ejecución Cross-Browser
*   **Objetivo:** Ejecutar las pruebas en distintos navegadores.
*   **Evidencia:** La clase `BaseTest.java` utiliza `WebDriverManager` y la anotación `@Parameters` para permitir la ejecución de pruebas en diferentes navegadores. El archivo `testing.xml` está configurado para lanzar las pruebas de login tanto en Chrome como en Firefox.

### Lección 7: Pruebas con Múltiples Datos (Clase: `Leccion7_MultiplesDatosTest.java`)
*   **Objetivo:** Parametrizar pruebas usando datos externos.
*   **Métricas Cumplidas:** La prueba de login se ejecuta utilizando un `DataProvider` (`DataProviderClass.java`) que provee múltiples combinaciones de credenciales para validar escenarios de éxito y de fallo.