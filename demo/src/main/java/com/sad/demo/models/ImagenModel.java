package com.sad.demo.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // denota que es una entidad
@Table(name = "imagen") // da el nombre a la tabla en mysql

public class ImagenModel {
    @Id // se genera el ID de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // el id tiene un auto_increment en la base de datos
    private Long IDimagen;

    // demas columnas de la tabla
    @Column
    private String path;
    @Column
    private int IDpropiedad;

    // get and set de cada columna

    public Long getIDimagen() {
        return this.IDimagen;
    }

    public void setIDimagen(Long IDimagen) {
        this.IDimagen = IDimagen;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getIDpropiedad() {
        return this.IDpropiedad;
    }

    public void setIDpropiedad(int IDpropiedad) {
        this.IDpropiedad = IDpropiedad;
    }
    

}
