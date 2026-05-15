# 🦷 Dentali REST API

**Dentali** es una potente API REST diseñada para la gestión integral de clínicas dentales. Ofrece una arquitectura moderna, segura y escalable para administrar pacientes, doctores, citas y registros médicos.

---

## 🚀 Características Principales

- **Gestión de Pacientes**: Registro detallado y seguimiento.
- **Gestión de Doctores (Odontólogos)**: Administración de especialidades y personal.
- **Sistema de Citas**: Agendamiento y control de estados de citas.
- **Historial Clínico Avanzado**: 
  - Control de **Signos Vitales** (Presión, IMC, Saturación, etc.).
  - Mapas dinámicos de **Antecedentes Patológicos y Familiares**.
  - Seguimiento de padecimientos y planes de tratamiento personalizados.
  - Clasificación por **Género y Estado Civil** mediante tipos enriquecidos.
- **Tratamientos y Pagos**: Control financiero y de procedimientos realizados.
- **Seguridad Centralizada**: Módulo de autenticación desacoplado con **JWT (JSON Web Tokens)**.
- **Arquitectura Limpia**: Organización por funcionalidades (**Package by Feature**) con separación clara de responsabilidades (Domain, Application, Infrastructure).
- **Gestión de Errores Profesional**: Respuestas estandarizadas en JSON para excepciones de negocio y validación.

---

## 🛠️ Tecnologías Utilizadas

- **Backend**: Java 21 & Spring Boot 3.5.x
- **Persistencia**: Spring Data JPA & PostgreSQL
- **Seguridad**: Spring Security & JWT
- **Documentación**: Swagger UI / OpenAPI 3
- **Utilidades**: Lombok, MapStruct, Jakarta Validation, Maven

---

## 🏗️ Arquitectura del Proyecto

El proyecto implementa una **Arquitectura por Funcionalidades**, donde cada módulo es independiente y sigue capas internas:

```text
com.dentali.features.<feature>
├── application        # DTOs (Records), Mappers y Casos de Uso (Service)
├── domain             # Modelos de Dominio y Contratos (Repository)
├── infrastructure     # Implementaciones técnicas (Security, JPA)
└── interfaces         # Controladores REST

com.dentali.core       # Lógica transversal y GlobalExceptionHandler
```

---

## 📖 Documentación de la API

La API está documentada automáticamente con Swagger. Una vez que el proyecto esté corriendo, puedes acceder a la interfaz interactiva en:

🔗 **[http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)**

---

## 📌 Endpoints Principales (v1)

### 🗓️ Citas (`/api/v1/citas`)
- `POST /api/v1/citas`: Agendar una nueva cita (Estado inicial: `PROGRAMADA`).
- `GET /api/v1/citas`: Listar todas las citas registradas.
- `GET /api/v1/citas/{id}`: Obtener la información detallada de una cita.
- `PUT /api/v1/citas/{id}`: Actualizar datos, fecha o personal de una cita existente.

### 👤 Pacientes (`/api/v1/pacientes`)
- `POST /api/v1/pacientes`: Registrar un nuevo paciente.
- `GET /api/v1/pacientes`: Listar todos los pacientes.
- `GET /api/v1/pacientes/{id}`: Buscar un paciente por su ID.
- `DELETE /api/v1/pacientes/{id}`: Eliminar el registro de un paciente.

---

## ⚙️ Instalación y Configuración


### Prerrequisitos
- JDK 21 o superior
- Maven 3.6+
- Instancia de PostgreSQL corriendo

### Pasos
1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/shomou/dentali-rest.git
   ```

2. **Configurar la base de datos**:
   Edita el archivo `src/main/resources/application.properties` con tus credenciales de PostgreSQL.

3. **Compilar y ejecutar**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

### 🐳 Ejecución con Docker (Recomendado)
El proyecto incluye soporte para Docker Compose, lo que levanta la base de datos y la API automáticamente:

1. Asegúrate de tener Docker instalado.
2. Ejecuta el comando:
   ```bash
   docker-compose up --build
   ```
3. La API estará disponible en `http://localhost:8081`.

---

## 🔐 Seguridad

Para acceder a la mayoría de los endpoints, es necesario:
1. Registrarse/Loguearse para obtener un **Token JWT**.
2. Incluir el token en la cabecera de las peticiones:
   `Authorization: Bearer <tu_token_aqui>`

---

## 📄 Licencia
Este proyecto es de código abierto. ¡Siéntete libre de contribuir!
