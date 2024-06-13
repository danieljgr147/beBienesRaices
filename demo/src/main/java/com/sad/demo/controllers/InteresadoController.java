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

import com.sad.demo.models.InteresadoModel;
import com.sad.demo.services.InteresadoService;

//en esta clase se reciben las peticiones en web
@RestController // da a entender que la clase tiene funcion controller
@RequestMapping("/interesado") // da el path para hacer las peticiones a la tabla elegida
public class InteresadoController {

      @Autowired
    private InteresadoService interesadoService;// se declara Cliente Service como variable

    // para obtener los datos de clientes
    @GetMapping
    public ArrayList<InteresadoModel> getInteresado() {
        return this.interesadoService.getInteresado();
    }

    // Guarda datos al hacer un post
    @PostMapping
    public InteresadoModel saveInteresado(@RequestBody InteresadoModel interesado) {
        return this.interesadoService.saveInteresado(interesado);
    }

    // para obtener los datos de clientes segun un ID especifico
    @GetMapping(path = "/{IDinteresado}")
    public Optional<InteresadoModel> getInteresadobyId(@PathVariable Long IDinteresado) {
        return this.interesadoService.getbyId(IDinteresado);
    }

    // obtiene solucitudes PUT, desde web/cliente
    @PutMapping(path = "/{IDinteresado}")
    public InteresadoModel updateById(@RequestBody InteresadoModel request, @PathVariable("IDinteresado") Long IDinteresado) {
        return this.interesadoService.updateById(request, IDinteresado);
    }

    // elimina datos por ID
    @DeleteMapping(path = "/{IDinteresado}")
    public String deleteById(@PathVariable("IDinteresado") Long IDinteresado) {
        boolean ok = this.interesadoService.deleteInteresado(IDinteresado);
        if (ok) {
            return "Cliente con el ID " + IDinteresado + " ha sido eliminado";
        } else {
            return "Hubo un problema y el cliente con el ID " + IDinteresado + " no ha podido ser eliminado";
        }
    }
}
