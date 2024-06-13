package com.sad.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sad.demo.Repository.IContratoRepository;
import com.sad.demo.models.ContratoModel;

@Service // denota clase de tipo servicio conecta repositorios
public class ContratoService {
  @Autowired // spring instancia lo siguiente de manera automatica
  IContratoRepository contratoRepository;// se declara una variable de repositorio

  // regresa los objetos dentro de ClienteModel, las columnas de la tabla cliente
  public ArrayList<ContratoModel> getContrato() {
    return (ArrayList<ContratoModel>) contratoRepository.findAll();// findAll muestra todos los registros
  }

  // guarda la informacion que se agregue en post
  public ContratoModel saveContrato(ContratoModel contrato) {
    return contratoRepository.save(contrato);
  }

  // busca por ID
  public Optional<ContratoModel> getbyId(Long IDcontrato) {
    return contratoRepository.findById(IDcontrato);
  }

  // para actualizar o modificar informacion en la tabla
  public ContratoModel updateById(ContratoModel request, Long IDcontrato) {
    ContratoModel contrato = contratoRepository.findById(IDcontrato).get();
    contrato.setFechaPago(request.getFechaPago());
    contrato.setIDcliente(request.getIDcliente());
    contrato.setIDpropiedad(request.getIDpropiedad());

    return contrato;
  }

  // para eliminar informacion de la tabla
  public Boolean deleteContrato(Long IDcontrato) {
    try {
      contratoRepository.deleteById(IDcontrato);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
