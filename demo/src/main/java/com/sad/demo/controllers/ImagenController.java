package com.sad.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import com.sad.demo.models.ClienteModel;
import com.sad.demo.models.ImagenModel;
import com.sad.demo.services.ImagenService;


//en esta clase se reciben las peticiones en web
@RestController // da a entender que la clase tiene funcion controller
@RequestMapping("/imagen") // da el path para hacer las peticiones a la tabla elegida
public class ImagenController {
   private ImagenService imagenService;

    @Autowired
    public ImagenController(ImagenService imagenService) {
        this.imagenService = imagenService;
    }

     @GetMapping
    public ArrayList<ImagenModel> getImagen() {
        return this.imagenService.getImagen();
    }

    @PostMapping("/imagen/guardar")
    public ResponseEntity<String> guardarImagen(@RequestParam("file") MultipartFile multipartFile) {
       
        if (multipartFile.isEmpty()) {
            return new ResponseEntity<>("Archivo vacío", HttpStatus.BAD_REQUEST);
        }

        try {
            // Generar un nombre único para el archivo
            
           String fileName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
           
            // Guardar la imagen en la carpeta "static/imagenes"
           
           Path path = Paths.get("src/main/resources/static/imagenes/" + fileName); 
           
            //src\main\resources\static\imagenes
            Files.write(path, multipartFile.getBytes());
            

             ImagenModel saveImagen(@RequestBody ImagenModel imagen) {
            return this.imagenService.saveImagen(imagen);
            }

            // Guardar el path en la base de datos
            //ImagenModel imagen = imagenService.guardarImagen("/imagenes/" + fileName);
            //ImagenModel imagen1= imagenService.saveImagen(imagen);

           //return new ResponseEntity<>("Imagen guardada con ID: " + imagen.getIDimagen(), HttpStatus.OK);
           return new ResponseEntity<>("Imagen guardada con ID: " , HttpStatus.OK);
          
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
       
    } 


     // para obtener los datos de imagen segun un ID especifico
    @GetMapping(path = "/{IDimagen}")
    public Optional<ImagenModel> getImagenbyId(@PathVariable Long IDimagen) {
        return this.imagenService.getbyId(IDimagen);
    }

    // obtiene solucitudes PUT, desde web/cliente
    @PutMapping(path = "/{IDimagen}")
    public ImagenModel updateById(@RequestBody ImagenModel request, @PathVariable("IDimagen") Long IDimagen) {
        return this.imagenService.updateById(request, IDimagen);
    }

    // elimina datos por ID
    @DeleteMapping(path = "/{IDimagen}")
    public String deleteById(@PathVariable("IDimagen") Long IDimagen) {
        boolean ok = this.imagenService.deleteImagen(IDimagen);
        if (ok) {
            return "imagen con el ID " + IDimagen + " ha sido eliminado";
        } else {
            return "Hubo un problema y la imagen con el ID " + IDimagen + " no ha podido ser eliminado";
        } 
    }

}
