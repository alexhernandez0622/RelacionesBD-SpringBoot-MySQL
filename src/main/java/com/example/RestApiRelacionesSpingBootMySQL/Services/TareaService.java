package com.example.RestApiRelacionesSpingBootMySQL.Services;


import com.example.RestApiRelacionesSpingBootMySQL.Entity.Tarea;
import com.example.RestApiRelacionesSpingBootMySQL.Entity.Usuario;
import com.example.RestApiRelacionesSpingBootMySQL.Repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    /**
     * Obtiene todas las tareas asociadas a un usuario.
     *
     * @param usuarioId El ID del usuario
     * @return Lista de tareas asociadas al usuario
     */
    public List<Tarea> obtenerTareasPorUsuario(Long usuarioId) {
        return tareaRepository.findByUsuarioId(usuarioId);
    }

    /**
     * Crea una nueva tarea y la asocia al usuario especificado por su ID.
     *
     * @param usuarioId El ID del usuario al que se asociará la tarea
     * @param tarea     La tarea a crear
     * @return La tarea creada y asociada al usuario
     */
    public Tarea crearTareaParaUsuario(Long usuarioId, Tarea tarea) {
        try {
            // Crea un nuevo objeto Usuario con el ID proporcionado
            Usuario usuario = new Usuario();
            usuario.setId(usuarioId);
            // Asigna el usuario a la tarea
            tarea.setUsuario(usuario);
            // Guarda la tarea en la base de datos y devuelve la tarea guardada
            return tareaRepository.save(tarea);
        } catch (Exception e) {
            // Si ocurre algún error al guardar la tarea, registra el error y devuelve null
            // Esto ayudará a identificar problemas de inserción en la base de datos
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Obtiene una tarea específica asociada a un usuario.
     *
     * @param usuarioId El ID del usuario
     * @param tareaId   El ID de la tarea
     * @return La tarea asociada al usuario y con el ID especificado
     */
    public Tarea obtenerTareaPorId(Long usuarioId, Long tareaId) {
        // Obtiene la tarea por su ID
        Optional<Tarea> tareaOptional = tareaRepository.findById(tareaId);
        if (tareaOptional.isPresent()) { // Verifica si la tarea existe
            Tarea tarea = tareaOptional.get(); // Obtiene la tarea
            // Verifica si la tarea pertenece al usuario
            if (tarea.getUsuario().getId().equals(usuarioId)) {
                return tarea; // Retorna la tarea si pertenece al usuario
            }
        }
        return null; // Retorna null si la tarea no se encuentra o no pertenece al usuario
    }

    /**
     * Actualiza una tarea asociada a un usuario.
     *
     * @param usuarioId El ID del usuario
     * @param tareaId   El ID de la tarea a actualizar
     * @param tarea     La tarea actualizada
     * @return La tarea actualizada
     */
    public Tarea actualizarTarea(Long usuarioId, Long tareaId, Tarea tarea) {
        tarea.setId(tareaId);
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        tarea.setUsuario(usuario);
        return tareaRepository.save(tarea);
    }

    /**
     * Elimina una tarea asociada a un usuario.
     *
     * @param usuarioId El ID del usuario
     * @param tareaId   El ID de la tarea a eliminar
     */
    public void eliminarTarea(Long usuarioId, Long tareaId) {
        // Busca la tarea por su ID
        Tarea tarea = tareaRepository.findById(tareaId).orElse(null);
        // Verifica si la tarea existe y pertenece al usuario
        if (tarea != null && tarea.getUsuario().getId().equals(usuarioId)) {
            tareaRepository.delete(tarea); // Elimina la tarea
        }
    }

}

