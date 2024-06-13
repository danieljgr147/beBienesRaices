package com.sad.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // denota que es una entidad
@Table(name = "cliente") // da el nombre a la tabla en mysql
public class ClienteModel {
    @Id // se genera el ID de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // el id tiene un auto_increment en la base de datos
    private Long IDcliente;

    // demas columnas de la tabla
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String telefono;
    @Column
    private String gmail;
    @Column
    private int IDfiador;

    // get and set de cada columna
    public Long getIDcliente() {
        return this.IDcliente;
    }

    public void setIDcliente(Long IDcliente) {
        this.IDcliente = IDcliente;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGmail() {
        return this.gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public int getIDfiador() {
        return this.IDfiador;
    }

    public void setIDfiador(int IDfiador) {
        this.IDfiador = IDfiador;
    }

}
