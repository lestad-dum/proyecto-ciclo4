/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventarioapp;

/**
 *
 * @author Eduardo
 */
public class Categoria {
    private int id_categoria;
    private String nombre_categoria;

    public Categoria(int id_categoria, String nombre_categoria) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
    }

    public void agregarCategoria() {
        System.out.println("Categoría agregada: " + nombre_categoria);
    }

    public void eliminarCategoria() {
        System.out.println("Categoría eliminada: " + nombre_categoria);
    }
}

