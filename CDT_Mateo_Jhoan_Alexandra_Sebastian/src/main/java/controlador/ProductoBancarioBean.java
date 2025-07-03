/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controlador;


import conexion.Conexion;
import dao.CDTDAO;
import java.io.Serializable;
import modelo.CDT;
import modelo.User;

/**
 *
 * @author mateo
 */

public class ProductoBancarioBean implements Serializable{
    
    private CDT cdt=new CDT();
    private User usuario=new User();
    private final CDTDAO cdtDAO = new CDTDAO();

    /**
     * Creates a new instance of ProductoBancarioBean
     */
    public ProductoBancarioBean() {
    }
    
    public String openFormulario(){
        return "formUsuarios?faces-redirect=true";
    }
    public String ver() {
        
        long numeroCuentaBuscar = cdt.getNumeroCuenta(); 
        CDT cdtEncontrado = cdtDAO.obtenerCDTPorNumeroCuenta(numeroCuentaBuscar);

        if (cdtEncontrado != null) {
            this.cdt = cdtEncontrado;
            System.out.println("CDT encontrado: " + cdt.getNumeroCuenta());
        } else {
            System.out.println("No se encontró un CDT con ese número de cuenta.");
        }

        return "";
    }
    
    //resto de formatos 

    public CDT getCdt() {
        return cdt;
    }

    public void setCdt(CDT cdt) {
        this.cdt = cdt;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
    
}
