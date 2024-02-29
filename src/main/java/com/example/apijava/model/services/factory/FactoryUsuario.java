package com.example.apijava.model.services.factory;

import com.example.apijava.model.dao.Usuario;
import com.example.apijava.model.dto.UsuarioListar;
import com.example.apijava.model.services.UsuarioServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactoryUsuario {

    @Autowired
    private AbstractFactory abstractFactory;

    public Usuario crearObjeto(Usuario user){
        UsuarioServiceImplement crearUsuario= (UsuarioServiceImplement) abstractFactory.crearObjeto("usuario");
        Usuario usuario=crearUsuario.crearObjeto(user);
        return usuario;
    }

    public List<UsuarioListar> listarObjetos(){
        UsuarioServiceImplement listarUsuario= (UsuarioServiceImplement) abstractFactory.crearObjeto("usuario");
        List<UsuarioListar> usersList=listarUsuario.listarObjetos();
        return usersList;
    }

}
