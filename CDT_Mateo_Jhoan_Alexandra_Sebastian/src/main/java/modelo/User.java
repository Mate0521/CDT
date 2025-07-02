/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author jhoan
 */
@Entity
@Table(name = "usuario")
public class User implements Serializable {
    
    @Id
    @Column(name = "cedula")
    private String cedula;
    
    @Column(name = "nombre") 
    private String nombre;
    
    @Column(name = "fecha_nac")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_nac;
    
    @Column(name = "nacionacionalidad")
    private String nacionalidad;
   

    public User() {
    }

    public User(String Nombre, String Cedula, Date fecha_nac, String nacionalidad) {
        this.nombre = Nombre;
        this.cedula = Cedula;
        this.fecha_nac = fecha_nac;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String Cedula) {
        this.cedula = Cedula;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }  
}
