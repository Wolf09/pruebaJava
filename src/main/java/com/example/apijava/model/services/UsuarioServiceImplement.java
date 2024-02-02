package com.example.apijava.model.services;

import com.example.apijava.controller.exceptions.UserNotFoundException;
import com.example.apijava.model.auth.GeneradorJwt;
import com.example.apijava.model.dao.Usuario;
import com.example.apijava.model.repositories.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImplement implements UsuarioService{
    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Usuario crearUsuario(Usuario user) {
        Optional<Usuario> email= userRepositoryJPA.buscarEmail(user.getEmail());
        Usuario usuario=null;
        user.setPassword2(user.getPassword());
        String passwordEncrypt=passwordEncoder.encode((user.getPassword2()));
            if (email.isEmpty()) {
                user.setModified(LocalDateTime.now());
                user.setLastLogin(LocalDateTime.now());
                user.setPassword2(passwordEncrypt);
                user.setIsactive(true);
                user.setToken(GeneradorJwt.generarToken());
                usuario = userRepositoryJPA.save(user);
            } else {
                throw new UserNotFoundException("El correo ya existe en la Base de Datos");
            }



        return usuario;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> users;
        users=userRepositoryJPA.findAll();
        return users;
    }
}
