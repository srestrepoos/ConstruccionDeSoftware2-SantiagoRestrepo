# Construcción de Software 2 - Proyecto Bancario

## Información General
- **Estudiante:** Santiago Restrepo
- **Asignatura:** Construcción de Software 2
- **Rama:** develop

## Tecnologías Utilizadas
- **Lenguaje:** Java 17
- **Gestor de dependencias:** Maven
- **Librerías principales:** Lombok (para generación de boilerplate), Spring Boot (estructura base para posteriores capas).

## Cómo ejecutar el proyecto (Compilación)
Este es un proyecto basado en Maven que por ahora contiene principalmente el Modelo de Dominio rico.

1. Asegúrese de tener Java 17 o superior instalado.
2. Desde la raíz de la carpeta `demo` (o donde se encuentre `mvnw`), ejecute el siguiente comando para limpiar y compilar el proyecto:

```bash
./mvnw clean compile
```

Si usa Windows y no tiene bash o prefiere PowerShell estándar:
```powershell
.\mvnw.cmd clean compile
```