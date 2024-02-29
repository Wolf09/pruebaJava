package com.example.apijava.model.repositories;

import com.example.apijava.model.dao.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepositoryJPA extends JpaRepository<Usuario, UUID> {
    @Query(value = "SELECT u FROM Usuario u WHERE u.email=?1")
    Optional<Usuario> buscarEmail(String email);


}
