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

import com.sad.demo.models.PropiedadModel;
import com.sad.demo.services.PropiedadService;

//en esta clase se reciben las peticiones en web
@RestController // da a entender que la clase tiene funcion controller
@RequestMapping("/propiedad") // da el path para hacer las peticiones a la tabla elegida
public class PropiedadController {
    @Autowired
    private PropiedadService PropiedadService;// se declara Propiedad Service como variable

    // para obtener los datos de propiedad
    @GetMapping
    public ArrayList<PropiedadModel> getPropiedad() {
        return this.PropiedadService.getPropiedad();
    }

    // Guarda datos al hacer un post
    @PostMapping
    public PropiedadModel savePropiedad(@RequestBody PropiedadModel propiedad) {
        return this.PropiedadService.savePropiedad(propiedad);
    }

    // para obtener los datos de propiedad segun un ID especifico
    @GetMapping(path = "/{IDpropiedad}")
    public Optional<PropiedadModel> getPropiedadbyId(@PathVariable Long IDpropiedad) {
        return this.PropiedadService.getbyId(IDpropiedad);
    }

    // obtiene solucitudes PUT, desde web/cliente
    @PutMapping(path = "/{IDpropiedad}")
    public PropiedadModel updateById(@RequestBody PropiedadModel request,
            @PathVariable("IDpropiedad") Long IDpropiedad) {
        return this.PropiedadService.updateById(request, IDpropiedad);
    }

    // elimina datos por ID
    @DeleteMapping(path = "/{IDpropiedad}")
    public String deleteById(@PathVariable("IDpropiedad") Long IDpropiedad) {
        boolean ok = this.PropiedadService.deletePropiedad(IDpropiedad);
        if (ok) {
            return "La propiedad con el ID " + IDpropiedad + " ha sido eliminado";
        } else {
            return "Hubo un problema y la propiedad con el ID " + IDpropiedad + " no ha podido ser eliminado";
        }
    }
}
