package com.example.apijava.model.auth;

import io.jsonwebtoken.Jwts;

import java.util.Date;

import static com.example.apijava.model.auth.TokenJwtConfig.*;
public class GeneradorJwt {


    public static String generarToken(){

        String token= Jwts.builder()
                .subject(USER_NAME)
                .expiration(new Date(System.currentTimeMillis()+ 7200000))
                .issuedAt(new Date())
                .signWith(SECRET_KEY)
                .compact();
        return token;

    }
}
