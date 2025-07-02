/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jhoan
 */
@Entity
@Table(name = "cdt")
public class CDT implements Serializable {
    
    @Id
    @Column(name = "numerocuenta") 
    private long numeroCuenta; //cedula+frcha+numero aleatorio 
    
    @Column(name = "invercion") 
    private double inversion;
    
    @Column(name = "interes")
    private double interes;
    
    @Column(name = "plazo")
    private double plazo;
    
    
    private double ganancia;
    private double valorFuturo;
    private double retencion;
    private static final double ANIO = 360;

    public CDT() {
    }

    public CDT(long numeroC, double inversion, double interes, double plazo, double ganancia, double valorFuturo, double  rete) {
        this.numeroCuenta=numeroC;
        this.inversion = inversion;
        this.interes = interes;
        this.plazo = plazo;
        this.ganancia = ganancia;
        this.valorFuturo = valorFuturo;
        this.retencion=rete;
    }

    public double getInversion() {
        return inversion;
    }

    public void setInversion(double inversion) {
        this.inversion = inversion;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getPlazo() {
        return plazo;
    }

    public void setPlazo(double plazo) {
        this.plazo = plazo;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public double getValorFuturo() {
        return valorFuturo;
    }

    public void setValorFuturo(double valorFuturo) {
        this.valorFuturo = valorFuturo;
    }

    public double getRetencion() {
        return retencion;
    }

    public void setRetencion(double retencion) {
        this.retencion = retencion;
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long NumeroCuenta) {
        this.numeroCuenta = NumeroCuenta;
    }
    
    
    
    
}
