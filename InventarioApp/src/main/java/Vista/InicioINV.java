package Vista;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Modelo.Usuario;
import conexionbd.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InicioINV{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese ID de persona existente: ");
        int id_persona = scanner.nextInt();

        // Verificar si la persona existe en la base de datos
        if (!verificarPersona(id_persona)) {
            System.out.println("La persona con ID " + id_persona + " no existe en la base de datos.");
            scanner.close();
            return; // Terminar el programa si la persona no existe
        }

        System.out.print("Ingrese nombre de usuario: ");
         scanner.nextLine();
        String nombreUsuario = scanner.nextLine();

        System.out.print("Ingrese rol (admin/trabajador): ");
        String rol = scanner.nextLine();

        System.out.print("Ingrese contraseña: ");
        String contraseña = scanner.nextLine();
        
        // Crear una instancia de Usuario
        Usuario nuevoUsuario = new Usuario(id_persona, null, null, nombreUsuario, rol, contraseña);
        
        // Llamar al método registrarUsuario
        nuevoUsuario.registrarUsuario();
        
        scanner.close();
    }
private static boolean verificarPersona(int id_persona) {
    try (Connection con = new BD().establecerConexion()) {
        String query = "SELECT * FROM PERSONA WHERE ID_PERSONA = ?"; // Asegúrate de que el nombre de la tabla sea correcto
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, id_persona);
        
        ResultSet rs = stmt.executeQuery();
        boolean existe = rs.next(); // Comprueba si hay al menos una fila

        if (existe) {
            System.out.println("La persona con ID " + id_persona + " existe en la base de datos.");
        } else {
            System.out.println("No se encontró la persona con ID " + id_persona + ".");
        }
        
        return existe; // Retorna verdadero si existe al menos una fila
    } catch (SQLException e) {
        System.err.println("ERROR AL CONECTARSE A LA BASE DE DATOS: " + e.getMessage());
    }
    return false; // Retorna falso si hay un error o si no existe
}

}
