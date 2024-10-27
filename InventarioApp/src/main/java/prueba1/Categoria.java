/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1;

/**
 *
 * @author Usuario
 */
public class Categoria {

    private String nombre_categoria;
    private int id_categoria;

    public Categoria(int id_categoria, String nombre_categoria) {
    this.id_categoria = id_categoria;
    this.nombre_categoria = nombre_categoria;
}

    
        public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    
    public void agregarCategoria() {
        // agregar categoría
    }

    public void eliminarCategoria() {
        // eliminar categoría
    }

    public void buscarCategoria() {
        // buscar categoría
    }
}
