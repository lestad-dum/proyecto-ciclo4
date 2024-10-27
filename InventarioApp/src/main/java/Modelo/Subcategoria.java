/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Subcategoria {
    
    private int id_subcate;
    private int id_cate;
    private String nombre_sub;

    public Subcategoria (int id_subcate, int id_cate, String nombre_sub){
    
    this.id_cate=id_cate;
    this.id_subcate=id_subcate;
    this.nombre_sub=nombre_sub;
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

    public void agregarSubCategoria() {
        
    }

    public void eliminarSubCategoria() {
        // eliminar subcategoría
    }

    public void buscarCategoria() {
        // buscar categoría
    }
}

