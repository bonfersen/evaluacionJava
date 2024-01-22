## Table of Contents
1. [General Info](#general-info)
2. [Tecnologias](#tecnologias)
3. [Instalacion](#instalacion)
### General Info
***
El proyecto expone un API con dos endpoints para el manejo de la entidad Usuario:
  * Busqueda de un usuario por su ID en uuid http://localhost:8080/api/usuario/find/072b0222-ca07-498e-a457-ed834809a073
  * Creacion de registro de un usuario con sus telefonos asociados http://localhost:8080/api/usuario/save/

Por defecto el proyecto ejecuta con la base de datos HSQLDB en memoria
Opcionalmente, si se desea persistir la data en HSQLDB server se puede ejecutar el archivo script.sql que crea las tablas y registros demo

El proyecto fue trabajado con el IDE de Intellij Idea

Los test se encuentran en el paquete y clase: com.evaluacion.bustamante.UsuarioControllerTest

Al levantar el proyecto, Swagger se encuentra configurado en la URL http://localhost:8080/swagger-ui/index.html
### Screenshot
![Image text](https://www.united-internet.de/fileadmin/user_upload/Brands/Downloads/Logo_IONOS_by.jpg)
## Tecnologias
***
A list of technologies used within the project:
* Java version 17 
* HyperSQL version 2.7.2
* Spring Boot version 3.2.2
* Spring Boot JPA version 3.2.2
## Instalacion
***
* Bajar el proyecto: git clone https://github.com/bonfersen/evaluacionJava.git
* Abrir la carpeta del proyecto con Intellij Idea
* Ejecutar la clase com.evaluacion.bustamante.BustamanteApplication
```

