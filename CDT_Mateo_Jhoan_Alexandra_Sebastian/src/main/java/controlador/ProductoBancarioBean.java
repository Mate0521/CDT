/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controlador;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import modelo.CDT;
import modelo.User;

/**
 *
 * @author mateo
 */
@Named(value = "productoBancarioBean")
@SessionScoped
public class ProductoBancarioBean implements Serializable{
    
    CDT cdt=new CDT();
    User usuario=new User();

    /**
     * Creates a new instance of ProductoBancarioBean
     */
    public ProductoBancarioBean() {
    }
    
    public String openFormulario(){
        return "formUsuarios?faces-redirect=true";
    }
    public String ver(){
        return "Mostrar?faces-redirect=true";
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
