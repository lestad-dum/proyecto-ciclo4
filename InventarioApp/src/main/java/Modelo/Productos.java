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
    private int id_categoria;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad_stock;
    private String marca;
    private String color;

    public Productos(int id_producto, int id_categoria, String nombre, String descripcion, double precio, int cantidad_stock, String marca, String color) {
        this.id_producto = id_producto;
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad_stock = cantidad_stock;
        this.marca = marca;
        this.color = color;
    }

    @Override
    public void agregarProducto() {
        try (Connection con = new BD().establecerConexion()) {
            String query = "INSERT INTO PRODUCTOS (ID_CATEGORIA, NOMBRE, DESCRIPCION, PRECIO, CANTIDAD_STOCK, MARCA, COLOR) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, this.id_categoria);
            stmt.setString(2, this.nombre);
            stmt.setString(3, this.descripcion);
            stmt.setDouble(4, this.precio);
            stmt.setInt(5, this.cantidad_stock);
            stmt.setString(6, this.marca);
            stmt.setString(7, this.color);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el producto");
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
                this.id_categoria = rs.getInt("ID_CATEGORIA");
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
