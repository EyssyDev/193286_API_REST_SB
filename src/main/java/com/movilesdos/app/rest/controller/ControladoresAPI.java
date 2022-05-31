package com.movilesdos.app.rest.controller;

import com.movilesdos.app.rest.models.Usuario;
import com.movilesdos.app.rest.repo.RepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladoresAPI {

    @Autowired
    private RepoUsuario repoUsuario;

    @GetMapping(value = "/")
    public String getPage() {
        return "Hola Mundo, la API Rest funciona.";
    }

    @GetMapping(value = "/listarUsuarios")
    public List<Usuario> listarUsuarios() {
        return repoUsuario.findAll();
    }

    @PostMapping(value = "/crearUsuario")
    public String crearUsuario(@RequestBody Usuario usuario) {
        repoUsuario.save(usuario);
        return "Usuario Registrado.";
    }

    @PutMapping(value = "/actualizarUsuario/{id}")
    public String actualizarUsuario(@PathVariable long id, @RequestBody Usuario usuario){
        Usuario usuarioActualizado = repoUsuario.findById(id).get();
        usuarioActualizado.setNombre(usuario.getNombre());
        usuarioActualizado.setCorreo(usuario.getCorreo());
        usuarioActualizado.setContrasena(usuario.getContrasena());
        repoUsuario.save(usuarioActualizado);
        return "Usuario Actualizado.";
    }

    @DeleteMapping(value = "/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable long id){
        Usuario eliminarUsuario = repoUsuario.findById(id).get();
        repoUsuario.delete(eliminarUsuario);
        return "Usuario eliminado con la id: " + id;
    }
}
