# PRUEBA TECNICA JAVA SMARTJOB - BANCO BCI


## Se desarrollo un API RESTFULL de creación de usuarios utilizando Java 17 y SpringBoot 3.2.3 y Base de Datos en Memoria H2

## Todos los mensajes incluyendo los mensajes de error retornan:

    {"mensaje": "mensaje de error"}


## Se utiliza JWT como token de acceso 

## Pruebas unitarias Junit5 y Mockito

## Swagger

## y el patron de diseño Abstract Factory

###  Ese endpoint deberá recibir un usuario con los campos "nombre", "correo", "contraseña", más un listado de objetos "teléfono", respetando el siguiente formato:


    {
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "hunter2",
    "phones": [
         {
            "number": "1234567",
             "citycode": "1",
            "contrycode": "57"
         } 
     ]
    
    }
### La respuesta en un codigo de status HTTP adecuado y mensaje de informacion en caso de error
### En caso de Exito se retorna el Usuario y otros datos solicitados
### Se hacen uso de las tecnologias solicitadas y Validaciones
## El proyecto fue creado utilizando el gestor de proyectos y paquetes Maven, se recomienda Utilizar el IDE Intellij IDEA community o ultimate, se deben ejecutar los siguientes comandos Maven:

    mvn clean            //Borra todos los .class y .jar generados. Dejando Limpio el proyecto
    mvn compile          //Compila el proyecto.
    mvn package          //Genera el jar.
    mvn install          //LLeva el jar a nuestro repositorio local de jars
    y despues debe levantar el proyecto con Spring 3.2.3 o superior

## Diagrama de Funcionamiento del API RESTFULL
<img height="900" src="https://github.com/Wolf09/pruebaJava/blob/main/src/main/resources/static/images/apiJava.png" width="800"/>