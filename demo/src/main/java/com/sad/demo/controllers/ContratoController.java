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

import com.sad.demo.models.ContratoModel;
import com.sad.demo.services.ContratoService;
//en esta clase se reciben las peticiones en web

@RestController // da a entender que la clase tiene funcion controller
@RequestMapping("/contrato") // da el path para hacer las peticiones a la tabla elegida
public class ContratoController {
    @Autowired
    private ContratoService contratoService;// se declara Contrato Service como variable

    // para obtener los datos de clientes
    @GetMapping
    public ArrayList<ContratoModel> getContrato() {
        return this.contratoService.getContrato();
    }

    // Guarda datos al hacer un post
    @PostMapping
    public ContratoModel saveContrato(@RequestBody ContratoModel contrato) {
        return this.contratoService.saveContrato(contrato);
    }

    // para obtener los datos de contrato segun un ID especifico
    @GetMapping(path = "/{IDcontrato}")
    public Optional<ContratoModel> getContratobyId(@PathVariable Long IDcontrato) {
        return this.contratoService.getbyId(IDcontrato);
    }

    // obtiene solucitudes PUT, desde web/cliente
    @PutMapping(path = "/{IDcontrato}")
    public ContratoModel updateById(@RequestBody ContratoModel request, @PathVariable("IDcontrato") Long IDcontrato) {
        return this.contratoService.updateById(request, IDcontrato);
    }

    // elimina datos por ID
    @DeleteMapping(path = "/{IDcontrato}")
    public String deleteById(@PathVariable("IDcontrato") Long IDcontrato) {
        boolean ok = this.contratoService.deleteContrato(IDcontrato);
        if (ok) {
            return "Cliente con el ID " + IDcontrato + " ha sido eliminado";
        } else {
            return "Hubo un problema y el cliente con el ID " + IDcontrato + " no ha podido ser eliminado";
        }
    }
}
