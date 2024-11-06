/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;

import Modelo.Usuario;
import javax.swing.*;
import conexionbd.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControladorSesion {
    private Usuario usuario;

    // Método para iniciar sesión
    public boolean iniciarSesion(String nombreUsuario, String password) {
    String hashedPassword = Usuario.hashPassword(password);
    try (Connection con = new BD().establecerConexion()) {
        String query = "SELECT * FROM USUARIOS WHERE NOMBRE = ? AND HASH_CONTRASEÑA = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, nombreUsuario);
        stmt.setString(2, hashedPassword);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("ID_PE");
            String nombre = rs.getString("NOMBRE");
            String rol = rs.getString("ROL");
            // Crear el usuario logueado
            usuario = new Usuario(id, nombre, null, nombreUsuario, rol, hashedPassword); // Ahora incluye nombreUsuario
            JOptionPane.showMessageDialog(null, "Bienvenido, " + nombre);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecto");
            return false;
        }
    } catch (SQLException e) {
        System.err.println("ERROR AL CONECTARSE A LA BASE DE DATOS");
        JOptionPane.showMessageDialog(null, "Intente ingresar luego");
        return false;
    }
}

    // Método para cerrar sesión
    public void cerrarSesion() {
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas cerrar sesión?", "Cerrar sesión", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Sesión cerrada. Saliendo del programa.");
            System.exit(0); // Cierra la aplicación
        }
    }

    // Método para verificar el rol
    
 public boolean  verificarPermisoAdmin() {
        if (usuario != null && !"admin".equalsIgnoreCase(usuario.getRol())) {
            JOptionPane.showMessageDialog(null, "Usted no puede realizar esta función", "Acceso Restringido", JOptionPane.WARNING_MESSAGE);
      return false;
        }
return true;
 }
}