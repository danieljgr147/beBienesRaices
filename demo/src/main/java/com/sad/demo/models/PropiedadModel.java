package com.sad.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // denota que es una entidad
@Table(name = "propiedad") // da el nombre a la tabla en mysql
public class PropiedadModel {
    @Id // se genera el ID de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // el id tiene un auto_increment en la base de datos
    private Long IDpropiedad;
    // demas columnas de la tabala
    @Column
    private String descripcion;
    @Column
    private int precio;
    @Column
    private String tipo;
    @Column
    private int IDdireccion;

    // get and set de cada columna
    public Long getIDpropiedad() {
        return this.IDpropiedad;
    }

    public void setIDpropiedad(Long IDpropiedad) {
        this.IDpropiedad = IDpropiedad;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return this.precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIDdireccion() {
        return this.IDdireccion;
    }

    public void setIDdireccion(int IDdireccion) {
        this.IDdireccion = IDdireccion;
    }

}
