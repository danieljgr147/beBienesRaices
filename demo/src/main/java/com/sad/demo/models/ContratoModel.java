package com.sad.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // denota que es una entidad
@Table(name = "contrato") // da el nombre a la tabla en mysql
public class ContratoModel {
    @Id // se genera el ID de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // el id tiene un auto_increment en la base de datos
    private Long IDcontrato;
    // demas columnas de la tabla
    @Column
    private String fechaPago;
    @Column
    private String IDcliente;
    @Column
    private String IDpropiedad;

    // get and set de cada columna
    public Long getIDcontrato() {
        return this.IDcontrato;
    }

    public void setIDcontrato(Long IDcontrato) {
        this.IDcontrato = IDcontrato;
    }

    public String getFechaPago() {
        return this.fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getIDcliente() {
        return this.IDcliente;
    }

    public void setIDcliente(String IDcliente) {
        this.IDcliente = IDcliente;
    }

    public String getIDpropiedad() {
        return this.IDpropiedad;
    }

    public void setIDpropiedad(String IDpropiedad) {
        this.IDpropiedad = IDpropiedad;
    }

}
