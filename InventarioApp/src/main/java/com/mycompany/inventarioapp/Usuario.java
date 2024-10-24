/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventarioapp;

/**
 *
 * @author Eduardo
 */
import java.time.LocalDate;

public class Usuario extends Persona {
    private String rol;
    private String hashContrasena;

    public Usuario(int id_persona, String nombre, LocalDate fecha_nacimiento, String rol, String hashContrasena) {
        super(id_persona, nombre, fecha_nacimiento);
        this.rol = rol;
        this.hashContrasena = hashContrasena;
    }

    @Override
    public void registrar_usuario() {
        System.out.println("Usuario registrado: " + nombre);
    }

    public void iniciarSesion() {
        System.out.println("Inicio de sesión de: " + nombre);
    }

    public void cerrarSesion() {
        System.out.println("Cierre de sesión de: " + nombre);
    }
}

