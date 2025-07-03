/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controlador;


import dao.CDTDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import modelo.CDT;
import modelo.User;

/**
 *
 * @author mateo
 */
@Named("productoBancarioBean")
@SessionScoped
public class ProductoBancarioBean implements Serializable{
    
    private CDT cdt=new CDT();
    private User usuario=new User();
    private final CDTDAO cdtDAO = new CDTDAO();
    private int num;

    /**
     * Creates a new instance of ProductoBancarioBean
     */
    public ProductoBancarioBean() {
    }
    
    public String openFormulario(){
        return "formUsuarios?faces-redirect=true";
    }
    public String ver() {
        CDT cdtEncontrado = cdtDAO.obtenerCDTPorNumeroCuenta(this.num);
        this.cdt=cdtEncontrado;
        return "datosUser.xhtml";
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
}
