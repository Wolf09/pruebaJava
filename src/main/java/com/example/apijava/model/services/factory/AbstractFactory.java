package com.example.apijava.model.services.factory;

import com.example.apijava.model.services.ObjetoService;
import com.example.apijava.model.services.UsuarioServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbstractFactory {

    @Autowired
    private UsuarioServiceImplement usuarioServiceImplement;

    public ObjetoService crearObjeto(String tipo){
            if(tipo.equalsIgnoreCase("usuario")){
                return usuarioServiceImplement;
            }
            return null;
    }

}
