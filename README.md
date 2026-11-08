# Proyecto Automatización de Pruebas - CI/CD Java (IPLACEX)

## 1. Integración Continua y Flujo de Trabajo

La Integración Continua (CI) consiste en integrar frecuentemente el código en un repositorio centralizado. Cada commit dispara un pipeline automático que compila, valida y ejecuta tests, entregando retroalimentación rápida al equipo, reduciendo el riesgo de regresiones y evitando el "integration hell".

## 2. Estructura del Proyecto

- `src/main/java`: Código de la lógica de negocio (`Calculadora.java`).
- `src/test/java`: Pruebas unitarias atómicas e independientes (`SumaTest.java`, `RestaTest.java`).
- `.github/workflows/ci.yml`: Configuración del pipeline de CI.
- `pom.xml`: Gestión de dependencias y plugins de prueba y reporte.
- `.gitignore`: Aislamiento de carpetas temporales (`/target/`, configuraciones de IDE).

## 3. Instrucciones de Ejecución Local

```bash
# Compilar
mvn clean compile

# Ejecutar pruebas unitarias
mvn test

# Generar reporte HTML
mvn surefire-report:report-only
```
