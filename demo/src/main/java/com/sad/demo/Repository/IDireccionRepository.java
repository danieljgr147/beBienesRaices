package com.sad.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sad.demo.models.DireccionModel;

public interface IDireccionRepository extends JpaRepository<DireccionModel, Long> {

}
