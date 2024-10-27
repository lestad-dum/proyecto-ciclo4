/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1;

public class Productos implements IProductos {
    private int id_producto;
    private int id_categoria;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad_stock;
    private String marca;
    private String color;

    public Productos (int id_producto, int id_categoria, String nombre, String descripcion, double precio, int cantidad_stock, String marca, String color) {
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
        // agregar producto
    }

    @Override
    public void eliminarProducto() {
        // eliminar producto
    }

    @Override
    public void actualizarStock() {
        // actualizar stock
    }

    @Override
    public void buscarProducto() {
        //buscar producto
    }
}
