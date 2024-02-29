package com.example.apijava.model.services;

import com.example.apijava.model.dao.Usuario;
import com.example.apijava.model.dto.UsuarioListar;
import com.example.apijava.model.repositories.UserRepositoryJPA;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class UsuarioServiceImplementTest {

    @Mock
    UserRepositoryJPA userRepositoryJPA;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    UsuarioServiceImplement usuarioServiceImplement;


    @Test
    void crearObjetoTest() {
        Usuario nuevoUsuario= DatosDePrueba.JUAN;
        when(userRepositoryJPA.buscarEmail("juan@algo.com")).thenReturn(Optional.empty());
        when(passwordEncoder.encode("Asssss1@")).thenReturn(DatosDePrueba.passwordEncrypt);
        when(userRepositoryJPA.save(nuevoUsuario)).thenReturn(DatosDePrueba.JUAN);
        Usuario usuarioCreado= usuarioServiceImplement.crearObjeto(nuevoUsuario);
        assertNotNull(usuarioCreado);
        assertEquals(UUID.fromString("40873633-71e7-4276-be4e-5277524203e8"),usuarioCreado.getUuid());
        assertTrue(usuarioCreado.getPhones().size()>0);

    }

    @Test
    void listarObjetosTest() {
        when(userRepositoryJPA.findAll()).thenReturn(DatosDePrueba.USUARIOS);
        List<UsuarioListar> usuarios= usuarioServiceImplement.listarObjetos();
        assertNotNull(usuarios);
        assertTrue(usuarios.size()>0);
        assertEquals(3,usuarios.size());

    }
}