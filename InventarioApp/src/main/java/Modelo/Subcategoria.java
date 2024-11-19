/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import conexionbd.BD;
import java.sql.*;

public class Subcategoria {

    private int id_subcate;
    private int id_cate;
    private String nombre_sub;

    public Subcategoria(int id_subcate, int id_cate, String nombre_sub) {
        this.id_cate = id_cate;
        this.id_subcate = id_subcate;
        this.nombre_sub = nombre_sub;
    }

    public int getId_subcate() {
        return id_subcate;
    }

    public void setId_subcate(int id_subcate) {
        this.id_subcate = id_subcate;
    }

    public int getId_cate() {
        return id_cate;
    }

    public void setId_cate(int id_cate) {
        this.id_cate = id_cate;
    }

    public String getNombre_sub() {
        return nombre_sub;
    }

    public void setNombre_sub(String nombre_sub) {
        this.nombre_sub = nombre_sub;
    }

    // Método para agregar una nueva subcategoría
    public void agregarSubCategoria() {
        BD conexion = new BD();
        Connection conn = conexion.establecerConexion();
        String query = "INSERT INTO SUBCATEGORIA (ID_CATE, NOMBRE_SUB) VALUES (?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id_cate);
            stmt.setString(2, nombre_sub);
            stmt.executeUpdate();
            System.out.println("Subcategoría agregada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar una subcategoría por ID
    public void eliminarSubCategoria() {
        BD conexion = new BD();
        Connection conn = conexion.establecerConexion();
        String query = "DELETE FROM SUBCATEGORIA WHERE ID_SUBCATE = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id_subcate);
            stmt.executeUpdate();
            System.out.println("Subcategoría eliminada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar una subcategoría por nombre
    public void buscarSubCategoria() {
        BD conexion = new BD();
        Connection conn = conexion.establecerConexion();
        String query = "SELECT * FROM SUBCATEGORIA WHERE NOMBRE_SUB = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombre_sub);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID_SUBCATE") +
                                   ", ID_CATE: " + rs.getInt("ID_CATE") +
                                   ", Nombre: " + rs.getString("NOMBRE_SUB"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


