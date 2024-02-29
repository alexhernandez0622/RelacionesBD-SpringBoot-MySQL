package com.example.RestApiRelacionesSpingBootMySQL.Services;

import com.example.RestApiRelacionesSpingBootMySQL.Entity.Usuario;
import com.example.RestApiRelacionesSpingBootMySQL.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired // Inyección de dependencia de UsuarioRepository
    private UsuarioRepository usuarioRepository;

    // Método para obtener todos los usuarios
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll(); // Utiliza el método del repositorio para obtener todos los usuarios
    }

    // Método para crear un nuevo usuario
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario); // Utiliza el método del repositorio para guardar un nuevo usuario en la base de datos
    }

    // Método para obtener un usuario por su ID
    public Usuario obtenerUsuarioPorId(Long usuarioId) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId); // Utiliza el método del repositorio para obtener un usuario por su ID
        return usuarioOptional.orElse(null); // Retorna el usuario encontrado o null si no se encuentra
    }

    // Método para actualizar un usuario por su ID
    public Usuario actualizarUsuario(Long usuarioId, Usuario usuario) {
        usuario.setId(usuarioId); // Establece el ID del usuario a actualizar
        return usuarioRepository.save(usuario); // Utiliza el método del repositorio para guardar el usuario actualizado en la base de datos
    }

    // Método para eliminar un usuario por su ID
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId); // Utiliza el método del repositorio para eliminar un usuario por su ID
    }
}
