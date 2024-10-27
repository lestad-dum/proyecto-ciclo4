/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import conexionbd.BD;
import java.sql.*;
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
      
        BD conexion = new BD();
        Connection mew = conexion.establecerConexion();
        String coma = "INSERT INTO CATEGORIAS(nombre_categoria) VALUES (?)";
       
        try (PreparedStatement gin = mew.prepareStatement(coma)){
            gin.setString(1,nombre_categoria);
            
        } catch (SQLException e){
            e.printStackTrace();
            
        }
        
    }

    public  void eliminarCategoria1() {
        
         BD conexion = new BD();
        Connection guf = conexion.establecerConexion();
         String mef = "DELETE FROM CATEGORIAS WHERE ID_CATEGORIA = ?";
         
         try(PreparedStatement gin = guf.prepareStatement(mef)){
             gin.setInt(1, id_categoria);
         } catch (SQLException e){
             e.printStackTrace();
         }
        
    }
    
    public void eliminarCategoria2(){
        BD conexion = new BD();
        Connection guf = conexion.establecerConexion();
         String sql = "DELETE FROM CATEGORIAS WHERE NOMBRE_CATEGORIA = ?";
   
           try(PreparedStatement gin = guf.prepareStatement(sql)){
             gin.setString(1, nombre_categoria);
         } catch (SQLException e){
             e.printStackTrace();
         }
    
    
    }

    public void buscarCategoria1() {
      
    }
    
    
    public void buscarCategoria2() {
      
    }
    
}
