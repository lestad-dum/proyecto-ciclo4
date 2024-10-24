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
import java.time.LocalDateTime;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Producto productoManager = new Producto(0, 0, "", "", 0.0, 0); // Instancia de Producto
    private Transaccion transaccionManager = new Transaccion(0, "", "", LocalDateTime.now()); // Instancia de Transaccion

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("*************************");
            System.out.println("*      Menú Principal    *");
            System.out.println("*************************");
            System.out.println("1. Ingresar un producto");
            System.out.println("2. Realizar una transacción");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado 'Ingresar un producto'.");
                    productoManager.ingresarProducto(); // Llama al método para ingresar un producto
                    break;
                case 2:
                    System.out.println("Has seleccionado 'Realizar una transacción'.");
                    transaccionManager.realizarTransaccion(); // Llama al método para realizar una transacción
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción del 1 al 3.");
                    break;
            }
        } while (opcion != 3);  // El menú se repite hasta que el usuario elija salir (opción 3)
    }
}


