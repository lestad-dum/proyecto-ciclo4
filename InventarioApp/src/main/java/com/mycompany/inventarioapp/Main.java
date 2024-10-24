/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.inventarioapp;

/**
 *
 * @author Eduardo
 */
public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        boolean accesoPermitido = login.iniciarSesion();

        if (!accesoPermitido) {
            System.out.println("El sistema se cerrará.");
            return;  // Salir del programa si el login no es exitoso
        }

        // Si el usuario ingresó credenciales correctas, mostrar el menú
        Menu menu = new Menu();
        menu.mostrarMenu();
    }
}
