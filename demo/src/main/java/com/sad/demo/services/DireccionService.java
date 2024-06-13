package com.sad.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sad.demo.Repository.IDireccionRepository;
import com.sad.demo.models.DireccionModel;

@Service // denota clase de tipo servicio conecta repositorios
public class DireccionService {
    @Autowired // spring instancia lo siguiente de manera automatica
    IDireccionRepository direccionRepository;// se declara una variable de repositorio

    // regresa los objetos dentro de ClienteModel, las columnas de la tabla cliente
    public ArrayList<DireccionModel> getDireccion() {
        return (ArrayList<DireccionModel>) direccionRepository.findAll();// findAll muestra todos los registros
    }

    // guarda la informacion que se agregue en post
    public DireccionModel saveDireccion(DireccionModel direccion) {
        return direccionRepository.save(direccion);
    }

    // busca por ID
    public Optional<DireccionModel> getbyId(Long IDdireccion) {
        return direccionRepository.findById(IDdireccion);
    }

    // para actualizar o modificar informacion en la tabla
    public DireccionModel updateById(DireccionModel request, Long IDdireccion) {
        DireccionModel direccion = direccionRepository.findById(IDdireccion).get();
        direccion.setProvincia(request.getProvincia());
        direccion.setDistrito(request.getDistrito());
        direccion.setCanton(request.getCanton());
        direccion.setSeñales(request.getSeñales());

        return direccion;
    }

    // para eliminar informacion de la tabla
    public Boolean deleteDireccion(Long IDdireccion) {
        try {
            direccionRepository.deleteById(IDdireccion);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
