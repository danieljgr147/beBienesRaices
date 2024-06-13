package com.sad.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // denota que es una entidad
@Table(name = "direccion") // da el nombre a la tabla en mysql
public class DireccionModel {
    @Id // se genera el ID de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // el id tiene un auto_increment en la base de datos
    private Long IDdireccion;
    // demas columnas de la tabla
    @Column
    private String provincia;
    @Column
    private String distrito;
    @Column
    private String canton;
    @Column
    private String señales;

    // get and set de cada columna
    public Long getIDdireccion() {
        return this.IDdireccion;
    }

    public void setIDdireccion(Long IDdireccion) {
        this.IDdireccion = IDdireccion;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return this.distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCanton() {
        return this.canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getSeñales() {
        return this.señales;
    }

    public void setSeñales(String señales) {
        this.señales = señales;
    }

}
