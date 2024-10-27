/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
import java.time.LocalDate;
import java.util.List;

public class Usuario extends Persona {
    private String rol;
    private String hashContraseña;

    public Usuario(int id_persona, String nombre, LocalDate fecha_nacimiento, String rol, String hashContraseña)  {
        
        super(id_persona, nombre, fecha_nacimiento);
        this.rol = rol;
        this.hashContraseña = hashContraseña;
        
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getHashContraseña() {
        return hashContraseña;
    }

    public void setHashContraseña(String hashContraseña) {
        this.hashContraseña = hashContraseña;
    }

    private boolean iniciarSesion() {
        // Implementación de inicio de sesión
        return true;
    }

    private  void cerrarSesion() {
        // Implementación de cierre de sesión
    }

    private List<Movimientos> verTransacciones() {
        // Retorna la lista de transacciones
        return null;
    }

    @Override
    public void registrarUsuario() {
        // Implementación de registrar usuario
    }
}

