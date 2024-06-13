package com.sad.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sad.demo.models.InteresadoModel;

public interface IInteresadoRepository extends JpaRepository<InteresadoModel, Long>  {
    
}
