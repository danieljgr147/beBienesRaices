package com.sad.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sad.demo.models.FiadorModel;

public interface IFiadorRepository extends JpaRepository<FiadorModel, Long> {

}
