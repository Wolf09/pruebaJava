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
