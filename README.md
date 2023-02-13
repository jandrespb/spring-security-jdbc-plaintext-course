# Spring security custom login con Maven - Java 

Proyecto práctica con spring security con su configuración básica.
Se debe tener en cuenta que en este proyecto se esta utilizando las siguientes versiones:
* Maven
* <springframework.version>5.3.22</springframework.version>
* <springsecurity.version>5.7.3</springsecurity.version>

## Pre-requisitos inicio desarrollo:
* Tener jdk 1.8 o jdk 11
* IDE (eclipse, IntelliJ) cualquiera de preferencia
* Servidor /Tomcat 9.0
* Proyecto Maven (perspectiva Java EE eclipse)
* MySQL

## funcionamiento Proyecto
Este proyecto aplicara las propiedades de Spring Security:
* Login : Formulario generado por Spring Security por defecto, pero fue mejorado dandole nuestros propios estilos.
* Roles Usuarios: Determinados desde la base de datos, para el ejemplo los roles son: ADMIN, EMPLOYEE, MANAGER.
* Usuarios y contraseñas: Generados desde la base de datos (sin encriptar contraseña{noop}).
* Creación página acceso denegado: En caso de que alguno de los roles intente acceder a un enlace en el que su rol no tiene autorización.
