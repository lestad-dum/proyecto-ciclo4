/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventarioapp;

/**
 *
 * @author Eduardo
 */
import java.util.Scanner;

public class Login {
    private String[] usuarios;
    private String[] contrasenas;

    public Login() {
        // Definir los usuarios y contraseñas directamente en el código
        usuarios = new String[]{"EDUARDO", "GINNY"};
        contrasenas = new String[]{"indesifrable", "indesifrable"};
    }

    // Método para iniciar sesión
    public boolean iniciarSesion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = scanner.nextLine().trim();

        System.out.println("Ingrese su contraseña:");
        String contrasena = scanner.nextLine().trim();

        // Validar si el usuario existe y si la contraseña es correcta
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i].equals(nombreUsuario) && contrasenas[i].equals(contrasena)) {
                System.out.println("Bienvenido, " + nombreUsuario + "!");
                return true;
            }
        }

        System.out.println("Acceso denegado: Usuario o contraseña incorrectos.");
        return false;
    }
}