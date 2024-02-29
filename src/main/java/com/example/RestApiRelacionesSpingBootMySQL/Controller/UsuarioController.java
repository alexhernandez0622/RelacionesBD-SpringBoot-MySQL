package com.example.RestApiRelacionesSpingBootMySQL.Controller;

import com.example.RestApiRelacionesSpingBootMySQL.Entity.Usuario;
import com.example.RestApiRelacionesSpingBootMySQL.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired // Inyección de dependencia de UsuarioService
    private UsuarioService usuarioService;

    // Mapea solicitudes HTTP GET a este método para obtener todos los usuarios
    @GetMapping
    public List<Usuario> obtenerTodosUsuarios() {
        // Llama al método del servicio para obtener todos los usuarios
        return usuarioService.obtenerTodosUsuarios();
    }

    @PostMapping // Mapea solicitudes HTTP POST a este método para crear un nuevo usuario
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        // Llama al método del servicio para crear un usuario
        return usuarioService.crearUsuario(usuario);
    }

    @GetMapping("/{usuarioId}") // Mapea solicitudes HTTP GET a este método para obtener un usuario por su ID
    public Usuario obtenerUsuarioPorId(@PathVariable Long usuarioId) {
        // Llama al método del servicio para obtener un usuario por su ID
        return usuarioService.obtenerUsuarioPorId(usuarioId);
    }

    @PutMapping("/{usuarioId}") // Mapea solicitudes HTTP PUT a este método para actualizar un usuario por su ID
    public Usuario actualizarUsuario(@PathVariable Long usuarioId, @RequestBody Usuario usuario) {
        // Llama al método del servicio para actualizar un usuario por su ID
        return usuarioService.actualizarUsuario(usuarioId, usuario);
    }

    @DeleteMapping("/{usuarioId}") // Mapea solicitudes HTTP DELETE a este método para eliminar un usuario por su ID
    public void eliminarUsuario(@PathVariable Long usuarioId) {
        // Llama al método del servicio para eliminar un usuario por su ID
        usuarioService.eliminarUsuario(usuarioId);
    }
}
