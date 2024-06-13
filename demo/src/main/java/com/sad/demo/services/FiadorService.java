package com.sad.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sad.demo.Repository.IFiadorRepository;
import com.sad.demo.models.FiadorModel;

@Service // denota clase de tipo servicio conecta repositorios
public class FiadorService {
  @Autowired // spring instancia lo siguiente de manera automatica
  IFiadorRepository fiadorRepository;// se declara una variable de repositorio

  // regresa los objetos dentro de ClienteModel, las columnas de la tabla cliente
  public ArrayList<FiadorModel> getFiador() {
    return (ArrayList<FiadorModel>) fiadorRepository.findAll();// findAll muestra todos los registros
  }

  // guarda la informacion que se agregue en post
  public FiadorModel saveFiador(FiadorModel fiador) {
    return fiadorRepository.save(fiador);
  }

  // busca por ID
  public Optional<FiadorModel> getbyId(Long IDfiador) {
    return fiadorRepository.findById(IDfiador);
  }

  // para actualizar o modificar informacion en la tabla
  public FiadorModel updateById(FiadorModel request, Long IDfiador) {
    FiadorModel fiador = fiadorRepository.findById(IDfiador).get();
    fiador.setNombre(request.getNombre());
    fiador.setApellido(request.getApellido());
    fiador.setTelefono(request.getTelefono());
    fiador.setGmail(request.getGmail());

    return fiador;
  }

  // para eliminar informacion de la tabla
  public Boolean deleteFiador(Long IDfiador) {
    try {
      fiadorRepository.deleteById(IDfiador);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
