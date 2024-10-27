/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1;

/**
 *
 * @author Usuario
 */
public class Division {
    
    private int id_division;
    private int id_cate;
    private int id_subcate;
    private String nombre_divi;
    
public Division(int id_division, int id_cate, int id_subcate, String nombre_divi) {
    this.id_division = id_division;
    this.id_cate = id_cate;
    this.id_subcate = id_subcate;
    this.nombre_divi = nombre_divi;
}

    
    public int getId_division() {
        return id_division;
    }

    public void setId_division(int id_division) {
        this.id_division = id_division;
    }

    public int getId_cate() {
        return id_cate;
    }

    public void setId_cate(int id_cate) {
        this.id_cate = id_cate;
    }

    public int getId_subcate() {
        return id_subcate;
    }

    public void setId_subcate(int id_subcate) {
        this.id_subcate = id_subcate;
    }

    public String getNombre_divi() {
        return nombre_divi;
    }

    public void setNombre_divi(String nombre_divi) {
        this.nombre_divi = nombre_divi;
    }

    public void agregarDivision() {
        // agregar división
    }

    public void eliminarDivision() {
        // eliminar división
    }

    public void buscarDivision() {
        // buscar división
    }
}
