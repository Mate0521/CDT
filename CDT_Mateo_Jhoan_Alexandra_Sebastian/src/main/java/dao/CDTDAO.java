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
<<<<<<< HEAD
        String sql = "INSERT INTO cdt (numerocuenta, inversion, interes, plazo) VALUES (?, ?, ?, ?)";

=======
        String sql = "INSERT INTO cdt (numerocuenta, invercion, interes, plazo) VALUES (?, ?, ?, ?)";
>>>>>>> 5e9d4c4954b65cbca55b1bb251723cd83a747424

        try (Connection conn = conexion.Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

<<<<<<< HEAD
            ps.setInt(1, cdt.getNumeroCuenta());
=======
            ps.setString(1, cdt.getNumeroCuenta());
>>>>>>> 5e9d4c4954b65cbca55b1bb251723cd83a747424
            ps.setDouble(2, cdt.getInversion());
            ps.setDouble(3, cdt.getInteres());
            ps.setDouble(4, cdt.getPlazo());
            //ps.setDouble(5, cdt.getGanancia());       // calculado
            //ps.setDouble(6, cdt.getValorFuturo());    // calculado
            //ps.setDouble(7, cdt.getRetencion());      // calculado

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception e) {
            System.out.println("Error al guardar CDT: " + e.getMessage());
            return false;
        }
    }

<<<<<<< HEAD
    public CDT obtenerCDTPorNumeroCuenta(long numeroCuenta) {
        String sql = "SELECT numerocuenta, inversion, interes, plazo FROM cdt WHERE numerocuenta = ?";
=======

    public CDT obtenerCDTPorNumeroCuenta(String numeroCuenta) {
        String sql = "SELECT numerocuenta, inversion, interes, plazo "
                   + "FROM cdt "
                   + "WHERE numerocuenta = ?";
>>>>>>> 5e9d4c4954b65cbca55b1bb251723cd83a747424

        try (Connection conn = conexion.Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, numeroCuenta);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                CDT cdt = new CDT();
<<<<<<< HEAD
                cdt.setNumeroCuenta(rs.getInt("numerocuenta"));
                cdt.setInversion(rs.getDouble("inversion")); // corregido
=======
                cdt.setNumeroCuenta(rs.getString("numerocuenta"));
                cdt.setInversion(rs.getDouble("inversion"));
>>>>>>> 5e9d4c4954b65cbca55b1bb251723cd83a747424
                cdt.setInteres(rs.getDouble("interes"));
                cdt.setPlazo(rs.getDouble("plazo"));
                
                System.out.println("CDT encontrado: "
                + cdt.getNumeroCuenta() + " "
                + cdt.getInversion() + " "
                + cdt.getInteres() + " "
                + cdt.getPlazo());


                rs.close();
                return cdt;
            } else {
                rs.close();
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error al obtener CDT: " + e.getMessage());
            return null;
        }
    }
}