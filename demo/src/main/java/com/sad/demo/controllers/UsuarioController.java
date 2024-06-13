package com.sad.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sad.demo.models.UsuarioModel;
import com.sad.demo.services.UsuarioService;

//en esta clase se reciben las peticiones en web
@RestController // da a entender que la clase tiene funcion controller
@RequestMapping("/usuario") // da el path para hacer las peticiones a la tabla elegida
public class UsuarioController {
    @Autowired
    private UsuarioService UsuarioService;// se declara Usuario Service como variable

    // para obtener los datos de usuario
    @GetMapping
    public ArrayList<UsuarioModel> getUsuario() {
        return this.UsuarioService.getUsuario();
    }

    // Guarda datos al hacer un post
    @PostMapping
    public UsuarioModel saveUsuario(@RequestBody UsuarioModel usuario) {
        return this.UsuarioService.saveUsuario(usuario);
    }

    // para obtener los datos de usuarios segun un ID especifico
    @GetMapping(path = "/{IDusuario}")
    public Optional<UsuarioModel> getUsuariobyId(@PathVariable Long IDusuario) {
        return this.UsuarioService.getbyId(IDusuario);
    }

    // obtiene solucitudes PUT, desde web/cliente
    @PutMapping(path = "/{IDusuario}")
    public UsuarioModel updateById(@RequestBody UsuarioModel request, @PathVariable("IDusuario") Long IDusuario) {
        return this.UsuarioService.updateById(request, IDusuario);
    }

    // elimina datos por ID
    @DeleteMapping(path = "/{IDusuario}")
    public String deleteById(@PathVariable("IDusuario") Long IDusuario) {
        boolean ok = this.UsuarioService.deleteUsuario(IDusuario);
        if (ok) {
            return "Usuario con el ID " + IDusuario + " ha sido eliminado";
        } else {
            return "Hubo un problema y el usuario con el ID " + IDusuario + " no ha podido ser eliminado";
        }
    }
}
