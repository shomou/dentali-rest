# Usar una imagen base de OpenJDK para Java 17
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de tu aplicación al contenedor
# Asegurar que el nombre del JAR coincida con el que genera el proyecto
COPY target/dentali-rest-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que la aplicacion SpringBoot escucha
EXPOSE 8081

# Comando para ejecutar la aplicación cuando el contenedor se inicie
ENTRYPOINT ["java","-jar","app.jar"]
