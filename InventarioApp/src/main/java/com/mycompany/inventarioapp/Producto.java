/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventarioapp;

/**
 *
 * @author Eduardo
 */
import java.util.Scanner;
public class Producto implements IProducto {
    private int id_producto;
    private int id_categoria;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad_stock;

    public Producto(int id_producto, int id_categoria, String nombre, String descripcion, double precio, int cantidad_stock) {
        this.id_producto = id_producto;
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad_stock = cantidad_stock;
    }

    @Override
    public void agregarProducto() {
        System.out.println("Producto agregado: " + nombre);
    }

    @Override
    public void eliminarProducto() {
        System.out.println("Producto eliminado: " + nombre);
    }

    @Override
    public void actualizarStock() {
        System.out.println("Stock actualizado para: " + nombre);
    }

    @Override
    public void buscarProducto() {
        System.out.println("Buscando producto: " + nombre);
    }
    public void ingresarProducto() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese ID del producto: ");
    int id_producto = scanner.nextInt();
    System.out.print("Ingrese ID de categoría: ");
    int id_categoria = scanner.nextInt();
    System.out.print("Ingrese nombre del producto: ");
    String nombre = scanner.next();
    System.out.print("Ingrese descripción del producto: ");
    String descripcion = scanner.next();
    System.out.print("Ingrese precio del producto: ");
    double precio = scanner.nextDouble();
    System.out.print("Ingrese cantidad en stock: ");
    int cantidad_stock = scanner.nextInt();

    // Crea un nuevo objeto Producto y lo agrega
    Producto nuevoProducto = new Producto(id_producto, id_categoria, nombre, descripcion, precio, cantidad_stock);
    nuevoProducto.agregarProducto(); // Llama al método para agregar el producto
}

}
