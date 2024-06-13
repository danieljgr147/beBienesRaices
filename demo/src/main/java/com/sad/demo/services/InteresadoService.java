package com.sad.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sad.demo.Repository.IInteresadoRepository;
import com.sad.demo.models.InteresadoModel;


@Service // denota clase de tipo servicio conecta repositorios
public class InteresadoService {
    
    @Autowired // spring instancia lo siguiente de manera automatica
    IInteresadoRepository interesadoRepository; // se declara una variable de repositorio

    // regresa los objetos dentro de ClienteModel, las columnas de la tabla cliente
    public ArrayList<InteresadoModel> getInteresado() {
        return (ArrayList<InteresadoModel>) interesadoRepository.findAll();// findAll muestra todos los registros
    }

    // guarda la informacion que se agregue en post
    public InteresadoModel saveInteresado(InteresadoModel interesado) {
        return interesadoRepository.save(interesado);
    }
  
    // busca por ID
    public Optional<InteresadoModel> getbyId(Long IDinteresado) {
        return interesadoRepository.findById(IDinteresado);
    }

    // para actualizar o modificar informacion en la tabla
    public InteresadoModel updateById(InteresadoModel request, Long IDinteresado) {
        InteresadoModel interesado = interesadoRepository.findById(IDinteresado).get();
        interesado.setNombre(request.getNombre());
        interesado.setApellido(request.getApellido());
        interesado.setTelefono(request.getTelefono());
        interesado.setGmail(request.getGmail());
        interesado.setMensaje(request.getMensaje());

        return interesado;
    }

    // para eliminar informacion de la tabla
    public Boolean deleteInteresado(Long IDinteresado) {
        try {
            interesadoRepository.deleteById(IDinteresado);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
