/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author MATEO CARVAJAL
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.CDT;


public class CDTDAO {

    public boolean guardarCDT(CDT cdt) {
        String sql = "INSERT INTO cdt (numerocuenta, inversion, interes, plazo) VALUES (?, ?, ?, ?)";

        try (Connection conn = conexion.Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cdt.getNumeroCuenta());
            ps.setDouble(2, cdt.getInversion());
            ps.setDouble(3, cdt.getInteres());
            ps.setDouble(4, cdt.getPlazo());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception e) {
            System.out.println("Error al guardar CDT: " + e.getMessage());
            return false;
        }
    }


    public CDT obtenerCDTPorNumeroCuenta(String numeroCuenta) {
        String sql = "SELECT numerocuenta, inversion, interes, plazo "
                   + "FROM cdt "
                   + "WHERE numerocuenta = ?";

        try (Connection conn = conexion.Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, numeroCuenta);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                CDT cdt = new CDT();
                cdt.setNumeroCuenta(rs.getString("numerocuenta"));
                cdt.setInversion(rs.getDouble("inversion"));
                cdt.setInteres(rs.getDouble("interes"));
                cdt.setPlazo(rs.getDouble("plazo"));

                rs.close();
                return cdt;
            } else {
                rs.close();
                return null; // no encontradoo
            }

        } catch (Exception e) {
            System.out.println("Error al obtener CDT: " + e.getMessage());
            return null;
        }
    }
    
}

