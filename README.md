# 🛡️ SheikahRegister: Hyrule Demographic Registry

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Latest-blue)](https://www.postgresql.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## 📜 Descripción del Proyecto

Tras la caída de Calamity Ganon, la Princesa Zelda ha ordenado la creación de un registro demográfico y taxonómico digitalizado de todo el reino. **SheikahRegister** es una API REST robusta diseñada para gestionar este censo masivo, permitiendo a Link registrar habitantes, aliados y especímenes de la fauna de Hyrule de manera eficiente y segura.

Este sistema implementa una arquitectura limpia y escalable, resolviendo problemas críticos de memoria mediante **paginación dinámica** y garantizando una comunicación estandarizada bajo los protocolos de la tecnología Sheikah.

---

## 🚀 Características Principales

*   **CRUD Completo de Especímenes**: Gestión integral de registros con validaciones de datos.
*   **Paginación y Ordenamiento Dinámico**: Implementación de `PageableResponse` 
*   **Estandarización de Respuestas**: Protocolo `GeneralResponse` unificado para todos los endpoints, incluyendo metadatos de tiempo y ruta.
*   **Control Global de Excepciones**: Manejo estético de errores mediante `GlobalExceptionHandler`, transformando excepciones técnicas en respuestas amigables (404, 500).
*   **Arquitectura Multicapa**: Separación clara de responsabilidades (Controller, Service, Repository, Mapper, DTO).

---

## 🛠️ Stack Tecnológico

| Tecnología | Propósito |
| :--- | :--- |
| **Java 17** | Lenguaje de programación principal. |
| **Spring Boot 3.2.5** | Framework para el desarrollo de la API REST. |
| **Spring Data JPA** | Persistencia de datos y abstracción de base de datos. |
| **PostgreSQL** | Motor de base de datos relacional. |
| **Lombok** | Reducción de código boilerplate (Getters, Setters, Builders). |
| **Maven** | Gestor de dependencias y construcción del proyecto. |

---

## ⚙️ Configuración y Ejecución

### Requisitos Previos
*   Java 17 instalado.
*   PostgreSQL en ejecución.
*   Maven 3.6+.

### Variables de Entorno
El sistema utiliza variables de desarrollo para la conexión a la base de datos. Puedes configurarlas en tu sistema o modificar el archivo `application.yaml`:

```yaml
DB_URL: jdbc:postgresql://localhost:5432/hyrule_db
DB_USERNAME: tu_usuario
DB_PASSWORD: tu_password
```

### Instalación
1. Clona el repositorio o descomprime el ZIP.
2. Navega a la raíz del proyecto.
3. Ejecuta el comando:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

---

## 📂 Estructura del Proyecto

```text
src/main/java/com/hyrule/sheikahregister/
├── controller/     # Endpoints de la API
├── service/        # Lógica de negocio e interfaces
├── repository/     # Acceso a datos (JPA)
├── domain/
│   ├── entity/     # Entidades de base de datos
│   └── dto/        # Objetos de transferencia de datos (Request/Response)
├── mapper/         # Transformación entre Entidades y DTOs
└── exception/      # Manejo de errores personalizado
```

---

## 🧪 Pruebas con Postman

Se incluye una colección de Postman en la raíz del proyecto.
Esta colección contiene pruebas preconfiguradas para:
1.  Registro de especímenes.
2.  Listado paginado con filtros de ordenamiento.
3.  Búsqueda por ID y actualización.
4.  Validación de errores 404 (Not Found).

---

## ✒️ Autor
Desarrollado con los estándares de la Corte Real de Hyrule. 🛡️
