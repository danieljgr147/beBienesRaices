package com.sad.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sad.demo.Repository.IClienteRepository;
import com.sad.demo.models.ClienteModel;

@Service // denota clase de tipo servicio conecta repositorios
public class ClienteService {
    @Autowired // spring instancia lo siguiente de manera automatica
    IClienteRepository clienteRepository; // se declara una variable de repositorio

    // regresa los objetos dentro de ClienteModel, las columnas de la tabla cliente
    public ArrayList<ClienteModel> getCliente() {
        return (ArrayList<ClienteModel>) clienteRepository.findAll();// findAll muestra todos los registros
    }

    // guarda la informacion que se agregue en post
    public ClienteModel saveCliente(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }
   
    // busca por ID
    public Optional<ClienteModel> getbyId(Long IDcliente) {
        return clienteRepository.findById(IDcliente);
    }

    // para actualizar o modificar informacion en la tabla
    public ClienteModel updateById(ClienteModel request, Long IDcliente) {
        ClienteModel cliente = clienteRepository.findById(IDcliente).get();
        cliente.setNombre(request.getNombre());
        cliente.setApellido(request.getApellido());
        cliente.setTelefono(request.getTelefono());
        cliente.setGmail(request.getGmail());
        cliente.setIDfiador(request.getIDfiador());

        return cliente;
    }

    // para eliminar informacion de la tabla
    public Boolean deleteCliente(Long IDcliente) {
        try {
            clienteRepository.deleteById(IDcliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
