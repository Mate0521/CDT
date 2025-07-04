/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controlador;


import conexion.Conexion;
import dao.CDTDAO;
import dao.UserDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
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
<<<<<<< HEAD
    private final UserDAO userDAO = new UserDAO();
    private int num;
=======
    private final UserDAO userDAO= new UserDAO();
    private String cc;
    private String num;
>>>>>>> 5e9d4c4954b65cbca55b1bb251723cd83a747424

    /**
     * Creates a new instance of ProductoBancarioBean
     */
    public ProductoBancarioBean() {
    }
    
    public String openFormulario(){
        return "formUsuarios?faces-redirect=true";
    }
    public String ver() {
        extraerObCDT(); 
        if (this.cdt != null) {
            extraerObUser(); 
            if(userDAO.autenticacion(this.num, this.cc)){
                return "datosUser.xhtml"; 
            }
            return null;
        } else {
            System.out.println("No se encontró ningún CDT con ese número de cuenta.");
            return null; // o regresa a la misma página mostrando mensaje de error
        }
        
    }
    
<<<<<<< HEAD
    
    public String guardar() {
    try {
        usuario.setCedula(usuario.getCedula().trim());
        usuario.setNombre(usuario.getNombre().trim());
        usuario.setNacionalidad(usuario.getNacionalidad().trim());
        // Guardar primero el CDT para que exista en la BD
        cdtDAO.guardarCDT(cdt);
        // Luego asociar la cuenta al usuario y guardar el usuario
        usuario.setNumerocuenta(cdt.getNumeroCuenta());
        userDAO.guardarUser(usuario);

        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage("Datos guardados correctamente."));
        this.usuario = new User();
        this.cdt = new CDT();
    } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar: " + e.getMessage(), null));
    }

    return null;
}
=======
    public void extraerObCDT(){
        try (Connection conn = Conexion.getConnection()) {
            System.out.println("<div>conexion exitosa</div>");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        CDT cdtEncontrado = cdtDAO.obtenerCDTPorNumeroCuenta(this.num);
        if (cdtEncontrado != null) {
            this.cdt = cdtEncontrado;
        } else {
            System.out.println("No se encontró ningún CDT con ese número de cuenta.");
        }
    }
    public void extraerObUser(){
        try (Connection conn = Conexion.getConnection()) {
            System.out.println("<div>conexión exitosa</div>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Asegúrate de que tienes la cédula del usuario disponible
        User userEncontrado = userDAO.obtenerUserPorCedula(this.cc); // Asegúrate de que cdt tenga el método getCedula()
        if (userEncontrado != null) {
            this.usuario = userEncontrado; // Almacena el usuario en una variable de instancia
        } else {
            System.out.println("No se encontró ningún usuario con esa cédula.");
        }
        
    }
    
    
>>>>>>> 5e9d4c4954b65cbca55b1bb251723cd83a747424

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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
    
    
}
