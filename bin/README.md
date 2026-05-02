# Dentali REST API

Proyecto Dentali es una API REST para administrar una clínica dental.

## Características

*   Gestión de pacientes
*   Gestión de odontólogos
*   Gestión de citas
*   Gestión de tratamientos
*   Gestión de historiales médicos
*   Autenticación y autorización con Spring Security y JWT

## Tecnologías Utilizadas

*   **Java 17**
*   **Spring Boot 3**
*   **Spring Web**
*   **Spring Data JPA**
*   **Spring Security**
*   **PostgreSQL** (Base de datos)
*   **Lombok**
*   **Maven** (Gestor de dependencias)
*   **JWT** (JSON Web Tokens para autenticación)

## Prerrequisitos

*   JDK 17 o superior
*   Maven 3.2+
*   PostgreSQL

## Cómo Empezar

1.  **Clona el repositorio:**

    ```bash
    git clone https://github.com/tu-usuario/dentali-rest.git
    cd dentali-rest
    ```

2.  **Configura la base de datos:**

    *   Abre el archivo `src/main/resources/application.properties`.
    *   Modifica las siguientes propiedades para que coincidan con tu configuración de PostgreSQL:

        ```properties
        spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_de_tu_bd
        spring.datasource.username=tu_usuario
        spring.datasource.password=tu_contraseña
        ```

3.  **Ejecuta la aplicación:**

    Puedes ejecutar la aplicación usando el wrapper de Maven incluido:

    ```bash
    ./mvnw spring-boot:run
    ```

    La aplicación estará disponible en `http://localhost:8082`.

## Endpoints de la API

A continuación se muestra una lista de los endpoints disponibles.

### Autenticación

*   `POST /api/users/login`: Inicia sesión y obtiene un token JWT.
*   `POST /api/users/register`: Registra un nuevo usuario y su doctor asociado.

### Usuarios

*   `GET /api/users/list`: (ADMIN) Lista todos los usuarios.

### Citas

*   `GET /api/citas/list`: Lista todas las citas.
*   `GET /api/citas/{id}`: Obtiene una cita por su ID.
*   `POST /api/citas`: Crea una nueva cita.
*   `PUT /api/citas/update/{id}`: Actualiza una cita existente.
*   `PUT /api/citas/cancel/{id}`: Cancela una cita.

### Historial Médico

*   `GET /api/historial/list`: Lista todos los historiales médicos.
*   `POST /api/historial`: Crea un nuevo historial médico.
*   `GET /api/historial/{id}`: Busca un historial médico por el ID del paciente.
*   `PUT /api/historial`: Actualiza un historial médico.

### Odontólogos

*   `GET /api/odontologos/list`: Lista todos los odontólogos.
*   `POST /api/odontologos`: Crea un nuevo odontólogo.
*   `GET /api/odontologos/{id}`: Obtiene un odontólogo por su ID.
*   `PUT /api/odontologos/{id}`: Actualiza un odontólogo existente.
*   `DELETE /api/odontologos/{id}`: Elimina un odontólogo.

### Pacientes

*   `GET /api/pacientes/list`: Lista todos los pacientes.
*   `POST /api/pacientes`: Crea un nuevo paciente.
*   `GET /api/pacientes/{id}`: Obtiene un paciente por su ID.
*   `PUT /api/pacientes/{id}`: Actualiza un paciente existente.
*   `DELETE /api/pacientes/{id}`: Elimina un paciente.

### Tratamientos

*   `GET /api/tratamientos/list`: Lista todos los tratamientos.
*   `POST /api/tratamientos`: Crea un nuevo tratamiento.
*   `GET /api/tratamientos/paciente/{id}`: Busca tratamientos por el ID del paciente.
*   `PUT /api/tratamientos/{id}`: Actualiza un tratamiento existente.
*   `DELETE /api/tratamientos/{id}`: Elimina un tratamiento.

---
_Este `README.md` fue generado por Gemini._
