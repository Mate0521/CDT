/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 *
 * @author jhoan
 */

public class CDT {
    
    private int numeroCuenta; //cedula+frcha+numero aleatorio 
    private double inversion;
    private double interes;
    private double plazo;
    private double ganancia;
    private double valorFuturo;
    private double retencion;
    private static final double ANIO = 360;

    public CDT() {
    }

    public CDT(int numeroC, double inversion, double interes, double plazo, double ganancia, double valorFuturo, double  rete) {
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
        this.ganancia = inversion * (interes / 100) * (plazo / ANIO);
        return this.ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public double getValorFuturo() {
        this.valorFuturo = inversion + getGanancia() - getRetencion();
        return this.valorFuturo;
    }

    public void setValorFuturo(double valorFuturo) {
        this.valorFuturo = valorFuturo;
    }

    public double getRetencion() {
        this.retencion = getGanancia() * 0.046; //  6% de retención
        return this.retencion;
    }

    public void setRetencion(double retencion) {
        this.retencion = retencion;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int NumeroCuenta) {
        this.numeroCuenta = NumeroCuenta;
    }
    
}
