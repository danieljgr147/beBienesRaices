package com.sad.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sad.demo.Repository.IPropiedadRepository;
import com.sad.demo.models.PropiedadModel;

@Service // denota clase de tipo servicio conecta repositorios
public class PropiedadService {
  @Autowired // spring instancia lo siguiente de manera automatica
  IPropiedadRepository propiedadRepository; // se declara una variable de repositorio

  // regresa los objetos dentro de ClienteModel, las columnas de la tabla cliente
  public ArrayList<PropiedadModel> getPropiedad() {
    return (ArrayList<PropiedadModel>) propiedadRepository.findAll();
  }

  // guarda la informacion que se agregue en post
  public PropiedadModel savePropiedad(PropiedadModel propiedad) {
    return propiedadRepository.save(propiedad);
  }

  // busca por ID
  public Optional<PropiedadModel> getbyId(Long IDpropiedad) {
    return propiedadRepository.findById(IDpropiedad);
  }

  // para actualizar o modificar informacion en la tabla
  public PropiedadModel updateById(PropiedadModel request, Long IDpropiedad) {
    PropiedadModel propiedad = propiedadRepository.findById(IDpropiedad).get();
    propiedad.setDescripcion(request.getDescripcion());
    propiedad.setPrecio(request.getPrecio());
    propiedad.setTipo(request.getTipo());
    propiedad.setIDdireccion(request.getIDdireccion());

    return propiedad;
  }

  // para eliminar informacion de la tabla
  public Boolean deletePropiedad(Long IDpropiedad) {
    try {
      propiedadRepository.deleteById(IDpropiedad);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
