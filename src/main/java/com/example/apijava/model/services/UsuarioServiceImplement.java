package com.example.apijava.model.services;

import com.example.apijava.controller.exceptions.UserNotFoundException;
import com.example.apijava.model.auth.GeneradorJwt;
import com.example.apijava.model.dao.Usuario;
import com.example.apijava.model.dto.UsuarioListar;
import com.example.apijava.model.repositories.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UsuarioServiceImplement implements ObjetoService<Usuario, UsuarioListar> {
    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioServiceImplement() {
    }

    public UsuarioServiceImplement(UserRepositoryJPA userRepositoryJPA, PasswordEncoder passwordEncoder) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public Usuario crearObjeto(Usuario user) {
        Optional<Usuario> email= userRepositoryJPA.buscarEmail(user.getEmail());
        Usuario usuario=null;
        user.setPasswordEncrypt(user.getPassword());
        String passwordEncrypt=passwordEncoder.encode((user.getPasswordEncrypt()));
        if (email.isEmpty()) {
            user.setModified(LocalDateTime.now());
            user.setLastLogin(LocalDateTime.now());
            user.setPasswordEncrypt(passwordEncrypt);
            user.setIsactive(true);
            user.setToken(GeneradorJwt.generarToken());
            usuario = userRepositoryJPA.save(user);
        } else {
            throw new UserNotFoundException("El correo ya existe en la Base de Datos");
        }



        return usuario;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioListar> listarObjetos() {
        List<Usuario> users;
        users=userRepositoryJPA.findAll();
        List<UsuarioListar> usersList = new ArrayList<>();
        users.forEach(usuario -> {
            UsuarioListar use=new UsuarioListar(usuario.getUuid(), usuario.getName(), usuario.getEmail(),
                    usuario.getCreated(),usuario.getModified(),usuario.getLastLogin(),usuario.getToken(),
                    usuario.getIsactive(),usuario.getPhones());
            usersList.add(use);
        });
        return usersList;
    }
}
