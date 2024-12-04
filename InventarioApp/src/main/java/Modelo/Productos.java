/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import conexionbd.BD;
import javax.swing.*;
import java.sql.*;

public class Productos implements IProductos {
    private int id_producto;
    private int id_division;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad_stock;
    private String marca;
    private String color;

    public Productos(int id_producto, int id_division, String nombre, String descripcion, double precio, int cantidad_stock, String marca, String color) {
        this.id_producto = id_producto;
        this.id_division = id_division;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad_stock = cantidad_stock;
        this.marca = marca;
        this.color = color;
    }

    @Override
    public void agregarProducto(int id_division, String nombre, String descripcion, double precio, int cantidad_stock, String marca, String color) {
        try (Connection con = new BD().establecerConexion()) {
            String query = "INSERT INTO PRODUCTOS (ID_DIVISION, NOMBRE, DESCRIPCIÓN_P, PRECIO, CANTIDAD_STO, MARCA, COLOR) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id_division);
            stmt.setString(2, nombre);
            stmt.setString(3, descripcion);
            stmt.setDouble(4, precio);
            stmt.setInt(5, cantidad_stock);
            stmt.setString(6, marca);
            stmt.setString(7, color);
            stmt.executeUpdate();
           System.out.println("Producto agregado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al agregar el producto");
        }
    }

    @Override
    public void eliminarProducto() {
        try (Connection con = new BD().establecerConexion()) {
            String query = "DELETE FROM PRODUCTOS WHERE ID_PRODUCTO = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, this.id_producto);
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto");
        }
    }

    @Override
    public void actualizarStock() {
        try (Connection con = new BD().establecerConexion()) {
            String query = "UPDATE PRODUCTOS SET CANTIDAD_STOCK = ? WHERE ID_PRODUCTO = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, this.cantidad_stock);
            stmt.setInt(2, this.id_producto);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Stock actualizado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el stock");
        }
    }

    @Override
    public void buscarProducto() {
        try (Connection con = new BD().establecerConexion()) {
            String query = "SELECT * FROM PRODUCTOS WHERE NOMBRE = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, this.nombre);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                this.id_producto = rs.getInt("ID_PRODUCTO");
                this.id_division = rs.getInt("ID_DIVISION");
                this.descripcion = rs.getString("DESCRIPCION");
                this.precio = rs.getDouble("PRECIO");
                this.cantidad_stock = rs.getInt("CANTIDAD_STOCK");
                this.marca = rs.getString("MARCA");
                this.color = rs.getString("COLOR");
                JOptionPane.showMessageDialog(null, "Producto encontrado");
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el producto");
        }
    }
}
