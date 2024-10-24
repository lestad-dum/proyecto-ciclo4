/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventarioapp;

/**
 *
 * @author Eduardo
 */
import java.time.LocalDateTime;
import java.util.Scanner;


public class Transaccion implements ITransaccion {
    private int id_transaccion;
    private String tipo_transaccion;
    private String cantidad;
    private LocalDateTime fecha;

    public Transaccion(int id_transaccion, String tipo_transaccion, String cantidad, LocalDateTime fecha) {
        this.id_transaccion = id_transaccion;
        this.tipo_transaccion = tipo_transaccion;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    @Override
    public void registrarTransaccion() {
        System.out.println("Transacción registrada: ID " + id_transaccion);
    }

    @Override
    public String obtenerDetallesTransaccion() {
        return "ID: " + id_transaccion + ", Tipo: " + tipo_transaccion + ", Cantidad: " + cantidad + ", Fecha: " + fecha;
    }

    public void consultarTransaccion() {
        System.out.println("Consultando transacción: ID " + id_transaccion);
    }
    public void realizarTransaccion() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese ID de la transacción: ");
    int id_transaccion = scanner.nextInt();
    System.out.print("Ingrese tipo de transacción (venta/compras): ");
    String tipo_transaccion = scanner.next();
    System.out.print("Ingrese cantidad: ");
    String cantidad = scanner.next();
    LocalDateTime fecha = LocalDateTime.now(); // Usamos la fecha y hora actual

    // Crea un nuevo objeto Transaccion y lo registra
    Transaccion nuevaTransaccion = new Transaccion(id_transaccion, tipo_transaccion, cantidad, fecha);
    nuevaTransaccion.registrarTransaccion(); // Llama al método para registrar la transacción
}

}

