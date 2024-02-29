package com.example.apijava.controller.exceptions;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.ServletException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> numberFormatException(NumberFormatException ex) {

        return getStringObjectMap(ex.getMessage());
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> noRutaException(NoHandlerFoundException ex) {

        return getStringObjectMap("Ruta No encontrada");
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> notFoundException(NullPointerException ex) {

        return getStringObjectMap("No existen registros en la base de datos, "+ex.getMessage());
    }


    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> userNotFoundException(Exception ex){

        return getStringObjectMap(ex.getMessage());
    }


    @ExceptionHandler({JwttException.class,JwtException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Map<String, String> jwtException(Exception ex){

        return getStringObjectMap(ex.getMessage());
    }


    @ExceptionHandler({Exception.class, IOException.class, ServletException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> datosFaltantes(Exception ex){

        return getStringObjectMap("Datos Faltantes o Inexistentes,  "+ex.getMessage());
    }


    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,Object> handleHTTPClientError(HttpClientErrorException ex){
        Map<String,Object> alg=new HashMap<>();
        if (ex.getStatusCode() == HttpStatus.FORBIDDEN){
            alg.put("message",ex.getMessage());
        } else if (ex.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            alg.put("message",ex.getMessage());
        }
        return alg;
    }

    private Map<String, String> getStringObjectMap(String ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", ex);


        return error;
    }

}
