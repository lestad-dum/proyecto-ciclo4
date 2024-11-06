/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import conexionbd.BD;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public abstract class Persona {
    private int id_persona;
    public String nombre;
    private LocalDate fecha_nacimiento;
    
    
   public Persona (int id_persona, String nombre, LocalDate fecha_nacimiento){
       
       this.id_persona=id_persona;
       this.nombre=nombre;
       this.fecha_nacimiento=fecha_nacimiento;
       
   }
    
     public int getIdPersona() {
        return id_persona;
    }

    public void setIdPersona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fecha_nacimiento;
    }

    public void setFechaNacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void registrarPersona(){
        try (Connection meow= new BD().establecerConexion()){
            
        } catch (SQLException e){
            System.err.println("Error en el registro en la base de datos");
            JOptionPane.showMessageDialog(null,"Error al registrar persona, intente de nuevo");
        }
    }
    public abstract void registrarUsuario();
    
}
