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
public class User {
    private String Nombre;
    private String Cedula;
    private Date fecha_nac;
    private String nacionalidad;
    private long NumeroCuenta; //cedula+frcha+numero aleatorio 

    public User() {
    }

    public User(String Nombre, String Cedula, Date fecha_nac, String nacionalidad, long NumeroCuenta) {
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.fecha_nac = fecha_nac;
        this.nacionalidad = nacionalidad;
        this.NumeroCuenta = NumeroCuenta;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
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

    public long getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(long NumeroCuenta) {
        this.NumeroCuenta = NumeroCuenta;
    }
    
    
}
