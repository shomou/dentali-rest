# 🦷 Dentali REST API

**Dentali** es una potente API REST diseñada para la gestión integral de clínicas dentales. Ofrece una arquitectura moderna, segura y escalable para administrar pacientes, doctores, citas y registros médicos.

---

## 🚀 Características Principales

- **Gestión de Pacientes**: Registro detallado y seguimiento.
- **Gestión de Doctores (Odontólogos)**: Administración de especialidades y personal.
- **Sistema de Citas**: Agendamiento y control de estados de citas.
- **Historial Clínico**: Registro digital de antecedentes, alergias y evoluciones.
- **Tratamientos y Pagos**: Control financiero y de procedimientos realizados.
- **Seguridad Robusta**: Autenticación y autorización basada en **JWT (JSON Web Tokens)**.
- **Arquitectura Modular**: Organizado por funcionalidades (**Package by Feature**) para facilitar la escalabilidad.

---

## 🛠️ Tecnologías Utilizadas

- **Backend**: Java 21 & Spring Boot 3.5.x
- **Persistencia**: Spring Data JPA & PostgreSQL
- **Seguridad**: Spring Security & JWT
- **Documentación**: Swagger UI / OpenAPI 3
- **Utilidades**: Lombok, MapStruct (opcional), Maven

---

## 🏗️ Arquitectura del Proyecto

El proyecto sigue un patrón de **Diseño Orientado a Funcionalidades (Package by Feature)**, lo que permite que cada módulo sea autónomo:

```text
com.dentali
├── features           # Módulos de negocio (Paciente, Cita, Doctor, etc.)
│   ├── cita
│   ├── paciente
│   └── ...
└── core               # Lógica transversal (Seguridad, Enums, Exceptions)
    ├── config
    ├── exceptions
    └── ...
```

---

## 📖 Documentación de la API

La API está documentada automáticamente con Swagger. Una vez que el proyecto esté corriendo, puedes acceder a la interfaz interactiva en:

🔗 **[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)**

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

---

## 🔐 Seguridad

Para acceder a la mayoría de los endpoints, es necesario:
1. Registrarse/Loguearse para obtener un **Token JWT**.
2. Incluir el token en la cabecera de las peticiones:
   `Authorization: Bearer <tu_token_aqui>`

---

## 📄 Licencia
Este proyecto es de código abierto. ¡Siéntete libre de contribuir!
