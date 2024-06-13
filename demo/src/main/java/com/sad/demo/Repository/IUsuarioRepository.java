package com.sad.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sad.demo.models.UsuarioModel;

public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long> {

}
