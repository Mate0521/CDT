/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
/**
 *
 * @author jhoan
 */

public class User{
    private String cedula; 
    private String nombre;
    private Date fecha_nac;
    private int numerocuenta;
    private String nacionalidad;
   

    public User() {
    }

    public User(String Nombre, String Cedula, Date fecha_nac, String nacionalidad, int numerocuenta) {
        this.nombre = Nombre;
        this.cedula = Cedula;
        this.fecha_nac = fecha_nac;
        this.numerocuenta = numerocuenta;
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

    public int getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(int numerocuenta) {
        this.numerocuenta = numerocuenta;
    }
    
}
