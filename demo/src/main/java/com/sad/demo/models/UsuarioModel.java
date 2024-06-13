package com.sad.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // denota que es una entidad
@Table(name = "usuario") // da el nombre a la tabla en mysql
public class UsuarioModel {
    @Id // se genera el ID de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // el id tiene un auto_increment en la base de datos
    private Long IDusuario;
    // demas columnas de la tabla
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String contraseña;
    @Column
    private String tipo;

    // get and set de cada columna
    public Long getIDusuario() {
        return this.IDusuario;
    }

    public void setIDusuario(Long IDusuario) {
        this.IDusuario = IDusuario;
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

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
