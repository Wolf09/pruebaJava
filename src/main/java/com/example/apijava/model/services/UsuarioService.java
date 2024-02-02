package com.example.apijava.model.services;

import com.example.apijava.model.dao.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario crearUsuario(Usuario user);

    List<Usuario> listarUsuarios();
}
