package com.example.apijava.model.services;

import com.example.apijava.model.dao.Telefono;
import com.example.apijava.model.dao.Usuario;

import java.time.LocalDateTime;
import java.util.*;

public class DatosDePrueba {

    private static final List<Telefono> TELEFONOJUAN= Arrays.asList(new Telefono("1234567","1","57"));

    private static final List<Telefono> TELEFONOCARLOS= Arrays.asList(new Telefono("7654321","2","58"));

    private static final List<Telefono> TELEFONOPATRICIA= Arrays.asList(new Telefono("5555555","3","59"));


    public static final Usuario JUAN= new Usuario(UUID.fromString("40873633-71e7-4276-be4e-5277524203e8"),"Juan Rodriguez","juan@algo.com",
            "Asssss1@", LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now(),"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwcnVlYmFKYXZhTmlzdW0iLCJleHAiOjE3MDkxNjQ4OTMsImlhdCI6MTcwOTE1NzY5M30.9cf-LoXbUB7WtsSx_1kFykePvApT4h0_BT5-5TOK4R0",
            true,TELEFONOJUAN);
    public static final Usuario CARLOS= new Usuario(UUID.fromString("50873633-71e7-4276-be4e-5277524203e8"),"Carlos Martinez","carlos@algo.com",
            "Asssss1@", LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now(),"fyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwcnVlYmFKYXZhTmlzdW0iLCJleHAiOjE3MDkxNjQ4OTMsImlhdCI6MTcwOTE1NzY5M30.9cf-LoXbUB7WtsSx_1kFykePvApT4h0_BT5-5TOK4R0",
            true,TELEFONOCARLOS);
    public static final Usuario PATRICIA= new Usuario(UUID.fromString("60873633-71e7-4276-be4e-5277524203e8"),"Patricia Rocabado","paty@algo.com",
            "Asssss1@", LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now(),"gyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwcnVlYmFKYXZhTmlzdW0iLCJleHAiOjE3MDkxNjQ4OTMsImlhdCI6MTcwOTE1NzY5M30.9cf-LoXbUB7WtsSx_1kFykePvApT4h0_BT5-5TOK4R0",
            true,TELEFONOPATRICIA);


    public static final List<Usuario> USUARIOS= Arrays.asList(JUAN,CARLOS,PATRICIA);
    public static final String passwordEncrypt="$2a$10$XFUCe0hDBLsIgQ7OEUpqBOGSMAwECaJYtdMA45nqmkHpE1aeVR8oi";



}
