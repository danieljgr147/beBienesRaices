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

import com.sad.demo.models.FiadorModel;
import com.sad.demo.services.FiadorService;
//en esta clase se reciben las peticiones en web

@RestController // da a entender que la clase tiene funcion controller
@RequestMapping("/fiador") // da el path para hacer las peticiones a la tabla elegida
public class FiadorController {
    @Autowired
    private FiadorService FiadorService;// se declara Fiador Service como variable

    // para obtener los datos de fiadores
    @GetMapping
    public ArrayList<FiadorModel> getFiador() {
        return this.FiadorService.getFiador();
    }

    // Guarda datos al hacer un post
    @PostMapping
    public FiadorModel saveFiador(@RequestBody FiadorModel fiador) {
        return this.FiadorService.saveFiador(fiador);
    }

    // para obtener los datos de clientes segun un ID especifico
    @GetMapping(path = "/{IDfiador}")
    public Optional<FiadorModel> getFiadorbyId(@PathVariable Long IDfiador) {
        return this.FiadorService.getbyId(IDfiador);
    }

    // obtiene solucitudes PUT, desde web/cliente
    @PutMapping(path = "/{IDfiador}")
    public FiadorModel updateById(@RequestBody FiadorModel request, @PathVariable("IDfiador") Long IDfiador) {
        return this.FiadorService.updateById(request, IDfiador);
    }

    // elimina datos por ID
    @DeleteMapping(path = "/{IDfiador}")
    public String deleteById(@PathVariable("IDfiador") Long IDfiador) {
        boolean ok = this.FiadorService.deleteFiador(IDfiador);
        if (ok) {
            return "El Fiador con el ID " + IDfiador + " ha sido eliminado";
        } else {
            return "Hubo un problema y el fiador con el ID " + IDfiador + " no ha podido ser eliminado";
        }
    }

}
