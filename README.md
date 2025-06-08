# Rodriguez_Alejandro_Delgado_Agustin_UT6UT7_NotasAPI

# NotasAPI – Proyecto UT6 y UT7

## Descripción del proyecto

Este proyecto es una API REST desarrollada en *Java con Spring Boot* como parte de las unidades UT6 (POO Avanzada) y UT7 (Ficheros y Base de Datos).  
Permite gestionar *Usuarios* y sus *Notas* con operaciones CRUD completas, relaciones JPA y controladores REST versionados.

Se puede probar utilizando *Postman* o herramientas como *cURL*.

----------------------------------------------------------------

## Instrucciones de ejecución

## Antes de ejecutar

Asegúrate de tener XAMPP encendido con el módulo MySQL activado.

Abre phpMyAdmin o tu base de datos preferida.

Crea una base de datos llamada exactamente:

CREATE DATABASE NotasApi;

### Opción 1: Ejecutar con *Visual Studio Code*

1. Abre el proyecto en VS Code.
2. Asegúrate de tener la extensión de Java instalada.
3. Haz clic en src/main/java/com/dam/NotasApi/NotasApiApplication.java.
4. Pulsa el botón Run en la parte superior de la clase (public static void main).

### Opción 2: Ejecutar con *NetBeans*

1. Abre NetBeans y selecciona *"Abrir proyecto"*.
2. Elige la carpeta del proyecto.
3. Haz clic derecho sobre el nombre del proyecto y selecciona *"Run"* o *"Ejecutar"*.
4. NetBeans compilará y arrancará automáticamente Spring Boot.

## Probar la API

Una vez en ejecución, accede a los endpoints en http://localhost:8080/api/v1 o http://localhost:8080/api/v2.  
Puedes hacer peticiones usando Postman, por ejemplo las capturas que estan en el .odt


----------------------------------------------------------------

## Enlace al repositorio GitHub

[https://github.com/AlejandroRodriguez05/Rodriguez_Alejandro_Delgado_Agustin_UT6UT7_NotasAPI.git](https://github.com/AlejandroRodriguez05/Rodriguez_Alejandro_Delgado_Agustin_UT6UT7_NotasAPI.git)
