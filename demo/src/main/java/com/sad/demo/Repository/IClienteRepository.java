package com.sad.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sad.demo.models.ClienteModel;

public interface IClienteRepository extends JpaRepository<ClienteModel, Long> {

}
