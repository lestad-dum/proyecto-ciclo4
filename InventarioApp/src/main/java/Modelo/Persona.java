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
    private String fecha_nacimiento;
    
    
   public Persona (int id_persona, String nombre, String fecha_nacimiento){
       
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

    public String getFechaNacimiento() {   
        return fecha_nacimiento;
    }

    public void setFechaNacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int registrarPersona(String nombre, String fecha){
         int idPersona = -1;
        try (Connection meow= new BD().establecerConexion()){
            String query = "INSERT INTO PERSONA (NOMBRE, FECHA_NACIMIENTO) VALUES (?, ?)";
            PreparedStatement stmt = meow.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,nombre);
            stmt.setString(2, fecha);
            stmt.executeUpdate();
              // Obtener el ID generado
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
             idPersona = rs.getInt(1);  // El primer valor es el ID generado automáticamente
            JOptionPane.showMessageDialog(null,"ID generado de la persona: " + idPersona);
            // Aquí puedes almacenar el idPersona si lo necesitas para el siguiente paso, o pasarlo a un método posterior
        }

            JOptionPane.showMessageDialog(null, "Persona registrada correctamente");
        } catch (SQLException e){
            System.err.println("Error en el registro en la base de datos");
        }
        return idPersona;
    }
    
    
    public abstract void registrarUsuario(String nombre, String fecha, String nombreusu, String rol, String contra);
    
}
