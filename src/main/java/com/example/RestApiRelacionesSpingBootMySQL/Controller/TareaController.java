package com.example.RestApiRelacionesSpingBootMySQL.Controller;

import com.example.RestApiRelacionesSpingBootMySQL.Entity.Tarea;
import com.example.RestApiRelacionesSpingBootMySQL.Services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {
    @Autowired // Inyección de dependencia de TareaService
    private TareaService tareaService;

    @GetMapping("/{usuarioId}") // Mapea solicitudes HTTP GET a este método para obtener todas las tareas de un usuario por su ID
    public List<Tarea> obtenerTareasPorUsuario(@PathVariable Long usuarioId)
    {
        // Llama al método del servicio para obtener todas las tareas de un usuario por su ID
        return tareaService.obtenerTareasPorUsuario(usuarioId);
    }

    @PostMapping("/{usuarioId}") // Mapea solicitudes HTTP POST a este método para crear una nueva tarea para un usuario por su ID
    public Tarea crearTareaParaUsuario(@PathVariable Long usuarioId, @RequestBody Tarea tarea)
    {
        // Llama al método del servicio para crear una nueva tarea para un usuario por su ID
        return tareaService.crearTareaParaUsuario(usuarioId, tarea);
    }

    @GetMapping("/{usuarioId}/{tareaId}") // Mapea solicitudes HTTP GET a este método para obtener una tarea por su ID y el ID del usuario al que pertenece
    public Tarea obtenerTareaPorId(@PathVariable Long usuarioId, @PathVariable Long tareaId)
    {
        // Llama al método del servicio para obtener una tarea por su ID y el ID del usuario al que pertenece
        return tareaService.obtenerTareaPorId(usuarioId, tareaId);
    }

    @PutMapping("/{usuarioId}/{tareaId}") // Mapea solicitudes HTTP PUT a este método para actualizar una tarea por su ID y el ID del usuario al que pertenece
    public Tarea actualizarTarea(@PathVariable Long usuarioId, @PathVariable Long tareaId, @RequestBody Tarea tarea)
    {
        // Llama al método del servicio para actualizar una tarea por su ID y el ID del usuario al que pertenece
        return tareaService.actualizarTarea(usuarioId, tareaId, tarea);
    }

    @DeleteMapping("/{usuarioId}/{tareaId}") // Mapea solicitudes HTTP DELETE a este método para eliminar una tarea por su ID y el ID del usuario al que pertenece
    public void eliminarTarea(@PathVariable Long usuarioId, @PathVariable Long tareaId)
    {
        // Llama al método del servicio para eliminar una tarea por su ID y el ID del usuario al que pertenece
        tareaService.eliminarTarea(usuarioId, tareaId);
    }
}
