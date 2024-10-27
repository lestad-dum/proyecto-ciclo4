/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Controlador;

import Modelo.Categoria;
import javax.swing.JOptionPane;

public class controladorCategoria {

    public void agregarCategoria(String nombreCategoria) {
        Categoria categoria = new Categoria(0, nombreCategoria); // ID se autoincrementa
        categoria.agregarCategoria();
        JOptionPane.showMessageDialog(null, "Categoría agregada exitosamente.");
    }

    public void eliminarCategoriaporId(int idCategoria) {
        Categoria categoria = new Categoria(idCategoria, null);
        categoria.eliminarCategoria1();
        JOptionPane.showMessageDialog(null, "Categoría eliminada exitosamente.");
    }

    public void eliminarCategoriaporNombre(String nombreCategoria) {
        Categoria categoria = new Categoria(0, nombreCategoria);
        categoria.eliminarCategoria2();
        JOptionPane.showMessageDialog(null, "Categoría eliminada exitosamente.");
    }

    public void buscarCategoriaPorNombre(String nombreCategoria) {
        Categoria categoria = new Categoria(0, nombreCategoria);
        categoria.buscarCategoria1();
        // Aquí puedes actualizar la vista con los resultados de la búsqueda
    }

    public void buscarCategoriaPorId(int idCategoria) {
        Categoria categoria = new Categoria(idCategoria, null);
        categoria.buscarCategoria2();
        // Aquí puedes actualizar la vista con los resultados de la búsqueda
    }
}
