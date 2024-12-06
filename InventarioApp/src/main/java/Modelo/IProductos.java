/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IProductos {
    
    void agregarProducto(int id_division, String nombre, String descripcion, double precio, int cantidad_stock, String marca, String colo);
    void eliminarProducto();
    void actualizarStock();
     List<Productos> buscarProducto(String nombre);
     List<Productos> buscarPorCodigo(int codigo);
     List<Productos> buscarPorCodigoDivision(int codigoDivision);
}

