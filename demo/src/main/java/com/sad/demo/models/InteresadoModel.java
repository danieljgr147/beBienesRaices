package com.sad.demo.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // denota que es una entidad
@Table(name = "interesados") // da el nombre a la tabla en mysql
public class InteresadoModel {
    @Id // se genera el ID de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // el id tiene un auto_increment en la base de datos
    private Long IDinteresado;

    // demas columnas de la tabla
    @Column
    private String nombre;
    // demas columnas de la tabla
    @Column
    private String apellido;
    // demas columnas de la tabla
    @Column
    private String telefono;
    // demas columnas de la tabla
    @Column
    private String gmail;
    // demas columnas de la tabla
    @Column
    private String mensaje;

    //guetters y setters

    public Long getIDinteresado() {
        return this.IDinteresado;
    }

    public void setIDinteresado(Long IDinteresado) {
        this.IDinteresado = IDinteresado;
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

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
