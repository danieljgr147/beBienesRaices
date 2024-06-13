package com.sad.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sad.demo.Repository.IUsuarioRepository;
import com.sad.demo.models.UsuarioModel;

@Service // denota clase de tipo servicio conecta repositorios
public class UsuarioService {
   @Autowired // spring instancia lo siguiente de manera automatica
   IUsuarioRepository usuarioRepository; // se declara una variable de repositorio

   // regresa los objetos dentro de ClienteModel, las columnas de la tabla cliente
   public ArrayList<UsuarioModel> getUsuario() {
      return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
   }

   // guarda la informacion que se agregue en post
   public UsuarioModel saveUsuario(UsuarioModel usuario) {
      return usuarioRepository.save(usuario);
   }

   // busca por ID
   public Optional<UsuarioModel> getbyId(Long IDusuario) {
      return usuarioRepository.findById(IDusuario);
   }

   // para actualizar o modificar informacion en la tabla
   public UsuarioModel updateById(UsuarioModel request, Long IDusuario) {
      UsuarioModel usuario = usuarioRepository.findById(IDusuario).get();
      usuario.setNombre(request.getNombre());
      usuario.setApellido(request.getApellido());
      usuario.setContraseña(request.getContraseña());
      usuario.setTipo(request.getTipo());

      return usuario;
   }

   // para eliminar informacion de la tabla
   public Boolean deleteUsuario(Long IDusuario) {
      try {
         usuarioRepository.deleteById(IDusuario);
         return true;
      } catch (Exception e) {
         return false;
      }
   }
}
