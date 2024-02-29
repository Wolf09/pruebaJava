package com.example.apijava.model.services;

import java.util.List;

public interface ObjetoService<T, U> {
    T crearObjeto(T t);

    List<U> listarObjetos();
}
