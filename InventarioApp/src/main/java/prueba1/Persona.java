/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1;
import java.time.LocalDate;
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
    
    public abstract void registrarUsuario();
    
}
