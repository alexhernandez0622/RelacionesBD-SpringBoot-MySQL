package com.example.RestApiRelacionesSpingBootMySQL.Repository;

import com.example.RestApiRelacionesSpingBootMySQL.Entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long>
{
    // Agrega el método findByUsuarioId para buscar tareas por el ID del usuario
    List<Tarea> findByUsuarioId(Long usuarioId);
}