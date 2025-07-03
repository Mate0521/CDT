/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.User;

/**
 *
 * @author MATEO CARVAJAL
 */
public class UserDAO {
     // Método para guardar un usuario en la base de datos
    public void guardarUser(User user) {
        String sql = "INSERT INTO user (cedula, nombre, fecha_nac, nacionalidad) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, user.getCedula());
            stmt.setString(2, user.getNombre());
            stmt.setDate(3, new java.sql.Date(user.getFecha_nac().getTime()));
            stmt.setString(4, user.getNacionalidad());
            
            stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al guardar el usuario: " + e.getMessage());
        }
    }
    
    // Método para obtener un usuario por cédula
    public User obtenerUserPorCedula(String cedula) {
        User user = null;
        String sql = "SELECT * FROM user WHERE cedula = ?";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cedula);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                user = new User();
                user.setCedula(rs.getString("cedula"));
                user.setNombre(rs.getString("nombre"));
                user.setFecha_nac(rs.getDate("fecha_nac"));
                user.setNacionalidad(rs.getString("nacionalidad"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al obtener el usuario: " + e.getMessage());
        }
        
        return user;
    }
}
