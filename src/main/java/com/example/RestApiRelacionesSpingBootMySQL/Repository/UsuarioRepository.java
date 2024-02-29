package com.example.RestApiRelacionesSpingBootMySQL.Repository;

import com.example.RestApiRelacionesSpingBootMySQL.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}