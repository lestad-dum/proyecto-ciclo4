/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import conexionbd.BD;
import java.sql.*;

public class Division {

    private int id_division;
    private int id_cate;
    private int id_subcate;
    private String nombre_divi;

    public Division(int id_division, int id_cate, int id_subcate, String nombre_divi) {
        this.id_division = id_division;
        this.id_cate = id_cate;
        this.id_subcate = id_subcate;
        this.nombre_divi = nombre_divi;
    }

    public int getId_division() {
        return id_division;
    }

    public void setId_division(int id_division) {
        this.id_division = id_division;
    }

    public int getId_cate() {
        return id_cate;
    }

    public void setId_cate(int id_cate) {
        this.id_cate = id_cate;
    }

    public int getId_subcate() {
        return id_subcate;
    }

    public void setId_subcate(int id_subcate) {
        this.id_subcate = id_subcate;
    }

    public String getNombre_divi() {
        return nombre_divi;
    }

    public void setNombre_divi(String nombre_divi) {
        this.nombre_divi = nombre_divi;
    }

    // Método para agregar una nueva división
    public void agregarDivision() {
        BD conexion = new BD();
        Connection conn = conexion.establecerConexion();
        String query = "INSERT INTO DIVISION (ID_CATE, ID_SUBCATE, NOMBRE_DIVI) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id_cate);
            stmt.setInt(2, id_subcate);
            stmt.setString(3, nombre_divi);
            stmt.executeUpdate();
            System.out.println("División agregada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar una división por ID
    public void eliminarDivision() {
        BD conexion = new BD();
        Connection conn = conexion.establecerConexion();
        String query = "DELETE FROM DIVISION WHERE ID_DIVISION = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id_division);
            stmt.executeUpdate();
            System.out.println("División eliminada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar una división por nombre
    public void buscarDivision() {
        BD conexion = new BD();
        Connection conn = conexion.establecerConexion();
        String query = "SELECT * FROM DIVISION WHERE NOMBRE_DIVI = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombre_divi);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID_DIVISION") + 
                                   ", ID_CATE: " + rs.getInt("ID_CATE") +
                                   ", ID_SUBCATE: " + rs.getInt("ID_SUBCATE") + 
                                   ", Nombre: " + rs.getString("NOMBRE_DIVI"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

