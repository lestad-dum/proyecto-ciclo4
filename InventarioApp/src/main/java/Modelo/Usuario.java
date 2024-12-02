/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
/**

/**
 *
 * @author Usuario
 */
import javax.swing.*;
import conexionbd.BD;
import java.security.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {
    private String nombreUsuario;
    private String rol;
    private String hashContraseña;

    public Usuario(int id_persona, String nombre, LocalDate fecha_nacimiento,String nombreUsuario, String rol, String hashContraseña)  {
        
        super(id_persona, nombre, fecha_nacimiento);
        this.nombreUsuario=nombreUsuario;
        this.rol = rol;
        this.hashContraseña = hashContraseña;
        
    }

    public String getnombreUsuario(){
        return nombreUsuario;
    }
    
    public void setnombreUsuario(String nombreUsuario){
        this.nombreUsuario=nombreUsuario;
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

    public static String hashPassword ( String password) {
        
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte [] hash = md.digest(password.getBytes());
            StringBuilder hexa = new StringBuilder();
            
            for(int i=0; i<hash.length;i++){
                byte b = hash[i];
                String hexab = String.format("%02x", b);
                hexa.append(hexab);
                
            }
            
           return hexa.toString();
        } catch (NoSuchAlgorithmException e){
            throw new RuntimeException (e);
        }
      
        
    }
  
 

    private List<Movimientos> verTransacciones() {
       
        return null;
       
    }

    
    
    @Override
    
 public void registrarUsuario() {
        String hashedPassword = hashPassword(this.hashContraseña); // Hashear la contraseña
        try (Connection con = new BD().establecerConexion()) {
            String query = "INSERT INTO USUARIOS (ID_PE, NOMBRE, ROL, HASH_CONTRASEÑA) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, this.getIdPersona());
            stmt.setString(2, this.nombreUsuario);
            stmt.setString(3, this.rol);
            stmt.setString(4, hashedPassword);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Error al registrar usuario");
        }
    }
        
 
 
 
 
}

