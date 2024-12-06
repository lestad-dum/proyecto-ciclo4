/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import conexionbd.BD;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Productos implements IProductos {
    private int id_producto;
    private int id_division;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad_stock;
    private String marca;
    private String color;

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_division() {
        return id_division;
    }

    public void setId_division(int id_division) {
        this.id_division = id_division;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad_stock() {
        return cantidad_stock;
    }

    public void setCantidad_stock(int cantidad_stock) {
        this.cantidad_stock = cantidad_stock;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

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
 
public  List<Productos> buscarProducto(String nombre) {
    List<Productos> listaProductos = new ArrayList<>();
    
    try (Connection con = new BD().establecerConexion()) {
        String query = "SELECT * FROM PRODUCTOS WHERE NOMBRE LIKE ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, "%" + nombre + "%"); // Usar LIKE para buscar productos que contengan el nombre

        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            // Crear un nuevo objeto Producto para cada resultado
            Productos p = new Productos(
                rs.getInt("ID_PRODUCTO"),
                rs.getInt("ID_DIVISION"),
                rs.getString("NOMBRE"),
                rs.getString("DESCRIPCION"),
                rs.getDouble("PRECIO"),
                rs.getInt("CANTIDAD_STOCK"),
                rs.getString("MARCA"),
                rs.getString("COLOR")
            );
            listaProductos.add(p); // Agregar el producto a la lista
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al buscar el producto");
    }
    
    return listaProductos; // Devolver la lista de productos encontrados
}
    public List<Productos> obtenerTodosLosProductos() {
    List<Productos> listaProductos = new ArrayList<>();
    
    try (Connection con = new BD().establecerConexion()) {
        String query = "SELECT * FROM PRODUCTOS";
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // Crear un objeto Producto por cada registro encontrado
            Productos producto = new Productos(
                rs.getInt("ID"),
                rs.getInt("ID_DIVISION"),
                rs.getString("NOMBRE"),
                rs.getString("DESCRIPCIÓN_P"), // Cambia si el nombre es diferente
                rs.getDouble("PRECIO"),
                rs.getInt("CANTIDAD_STO"),
                rs.getString("MARCA"),
                rs.getString("COLOR")
            );

            // Agregar el producto a la lista
            listaProductos.add(producto);
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener todos los productos: " + e.getMessage());
    }

    return listaProductos;
}

    @Override
    public List<Productos> buscarPorCodigo(int codigo) {
List<Productos> listaProductos = new ArrayList<>();
    
    try (Connection con = new BD().establecerConexion()) {
        String query = "SELECT * FROM PRODUCTOS WHERE ID_PRODUCTO = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, codigo); // Buscar por código exacto

        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            // Crear un nuevo objeto Producto para cada resultado
            Productos p = new Productos(
                rs.getInt("ID"),
                rs.getInt("ID_DIVISION"),
                rs.getString("NOMBRE"),
                rs.getString("DESCRIPCIÓN_P"),
                rs.getDouble("PRECIO"),
                rs.getInt("CANTIDAD_STO"),
                rs.getString("MARCA"),
                rs.getString("COLOR")
            );
            listaProductos.add(p); // Agregar el producto a la lista
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al buscar el producto por código");
    }
    
    return listaProductos; // Devolver la lista de productos encontrados
    }

    @Override
    public List<Productos> buscarPorCodigoDivision(int codigoDivision) {
        
          List<Productos> listaProductos = new ArrayList<>();
    
    try (Connection con = new BD().establecerConexion()) {
        String query = "SELECT * FROM PRODUCTOS WHERE ID_DIVISION = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, codigoDivision); // Buscar por código de división

        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            // Crear un nuevo objeto Producto para cada resultado
            Productos p = new Productos(
                rs.getInt("ID"),
                rs.getInt("ID_DIVISION"),
                rs.getString("NOMBRE"),
                rs.getString("DESCRIPCIÓN_P"),
                rs.getDouble("PRECIO"),
                rs.getInt("CANTIDAD_STO"),
                rs.getString("MARCA"),
                rs.getString("COLOR")
            );
            listaProductos.add(p); // Agregar el producto a la lista
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al buscar el producto por código de división");
    }
    
    return listaProductos; // Devolver la lista de productos encontrados
        
    }
    
    
    
}
