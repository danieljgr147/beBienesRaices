package com.sad.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sad.demo.models.ImagenModel;

public interface IImagenRepository extends JpaRepository<ImagenModel, Long> {
    
}
