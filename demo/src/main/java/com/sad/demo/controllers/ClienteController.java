package com.sad.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sad.demo.models.ClienteModel;
import com.sad.demo.services.ClienteService;

//en esta clase se reciben las peticiones en web
@RestController // da a entender que la clase tiene funcion controller
@RequestMapping("/cliente") // da el path para hacer las peticiones a la tabla elegida
@CrossOrigin(origins = "http://localhost:8080")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;// se declara Cliente Service como variable

    // para obtener los datos de clientes
    @GetMapping
    public ArrayList<ClienteModel> getCliente() {
        return this.clienteService.getCliente();
    }

    // Guarda datos al hacer un post
    @PostMapping
    public ClienteModel saveCliente(@RequestBody ClienteModel cliente) {
        return this.clienteService.saveCliente(cliente);
    }

    // para obtener los datos de clientes segun un ID especifico
    @GetMapping(path = "/{IDcliente}")
    public Optional<ClienteModel> getClientebyId(@PathVariable Long IDcliente) {
        return this.clienteService.getbyId(IDcliente);
    }

    // obtiene solucitudes PUT, desde web/cliente
    @PutMapping(path = "/{IDcliente}")
    public ClienteModel updateById(@RequestBody ClienteModel request, @PathVariable("IDcliente") Long IDcliente) {
        return this.clienteService.updateById(request, IDcliente);
    }

    // elimina datos por ID
    @DeleteMapping(path = "/{IDcliente}")
    public String deleteById(@PathVariable("IDcliente") Long IDcliente) {
        boolean ok = this.clienteService.deleteCliente(IDcliente);
        if (ok) {
            return "Cliente con el ID " + IDcliente + " ha sido eliminado";
        } else {
            return "Hubo un problema y el cliente con el ID " + IDcliente + " no ha podido ser eliminado";
        } 
    }
}
