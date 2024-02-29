package com.example.apijava.controller;

import com.example.apijava.model.dao.Usuario;
import com.example.apijava.model.dto.Error;
import com.example.apijava.model.dto.UsuarioListar;
import com.example.apijava.model.services.factory.FactoryUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private FactoryUsuario factoryUsuario;

    @PostMapping("/crear")
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario user, BindingResult result){
        ResponseEntity<Usuario> usuario;
        ResponseEntity<List<Error>> errores;
        if (result.hasErrors()){
            List<Error> error=new ArrayList<>();
            result.getFieldErrors().forEach(err ->{
                error.add(new Error(err.getDefaultMessage()));
            });
            errores=new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
            return errores;
        }
        usuario=new ResponseEntity<>(factoryUsuario.crearObjeto(user), HttpStatus.OK);
        return usuario;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioListar>> listarUsuarios(){
        ResponseEntity<List<UsuarioListar>> miLista;
        miLista= new ResponseEntity<>(factoryUsuario.listarObjetos(), HttpStatus.OK);
        return miLista;
    }


}
