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

import com.sad.demo.models.DireccionModel;
import com.sad.demo.services.DireccionService;
//en esta clase se reciben las peticiones en web

@RestController // da a entender que la clase tiene funcion controller
@RequestMapping("/direccion") // da el path para hacer las peticiones a la tabla elegida
public class DireccionController {
    @Autowired
    private DireccionService DireccionService;// se declara Direccion Service como variable

    // para obtener los datos de direccion
    @GetMapping
    public ArrayList<DireccionModel> getDireccion() {
        return this.DireccionService.getDireccion();
    }

    // Guarda datos al hacer un post
    @PostMapping
    public DireccionModel saveDireccion(@RequestBody DireccionModel direccion) {
        return this.DireccionService.saveDireccion(direccion);
    }

    // para obtener los datos de clientes segun un ID especifico
    @GetMapping(path = "/{IDdireccion}")
    public Optional<DireccionModel> getDireccionbyId(@PathVariable Long IDdireccion) {
        return this.DireccionService.getbyId(IDdireccion);
    }

    // obtiene solucitudes PUT, desde web/cliente
    @PutMapping(path = "/{IDdireccion}")
    public DireccionModel updateById(@RequestBody DireccionModel request,
            @PathVariable("IDdireccion") Long IDdireccion) {
        return this.DireccionService.updateById(request, IDdireccion);
    }

    // elimina datos por ID
    @DeleteMapping(path = "/{IDdireccion}")
    public String deleteById(@PathVariable("IDdireccion") Long IDdireccion) {
        boolean ok = this.DireccionService.deleteDireccion(IDdireccion);
        if (ok) {
            return "La direccion con el ID " + IDdireccion + " ha sido eliminado";
        } else {
            return "Hubo un problema y la direccion con el ID " + IDdireccion + " no ha podido ser eliminado";
        }
    }
}
