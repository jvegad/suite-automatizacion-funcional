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

### Lección 1: Testing Funcional con Selenium (Realizado por Viki Borda)

*   **Objetivo:** Comprender los fundamentos de Selenium y validar la instalación del entorno.
*   **Métrica:** Mínimo 1 prueba ejecutada con éxito.
*   **Resultado:** Esta sección fue completada por la compañera de equipo.

---

### Lección 2: Prototipado con Selenium IDE (Realizado por Josselyn Vega)

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