# PRUEBA TECNICA JAVA


## Se desarrollo un API RESTFULL de creacion de usuarios

## Los endpoints aceptan y retornan JSON siguiendo el formato:

    {"mensaje": "mensaje de error"}


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
### La respuesta en un codigo HTTP adecuado y mensaje de informacion en caso de error
### En caso de Exito se retorna el Usuario y otros datos solicitados
### Se hacen uso de las tecnologias solicitadas y Validaciones
## El proyecto fue creado utilizando el gestor de proyectos y paquetes Maven, por tanto debe contar con maven en su maquina o embebido en su IDE comandos:

    mvn clean            //Borra todos los .class y .jar generados. Dejando Limpio el proyecto
    mvn compile          //Compila el proyecto.
    mvn package          //Genera el jar.
    mvn install          //LLeva el jar a nuestro repositorio local de jars
    y despues debe levantar el poryecto con Spring 3.1.2 o superior

<img height="900" src="https://github.com/Wolf09/pruebaJava/blob/main/src/main/resources/static/images/apiJava.png" width="800"/>