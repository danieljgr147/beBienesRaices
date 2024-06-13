package com.sad.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sad.demo.models.PropiedadModel;

public interface IPropiedadRepository extends JpaRepository<PropiedadModel, Long> {

}
