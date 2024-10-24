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

public abstract class Persona {
    protected int id_persona;
    protected String nombre;
    protected LocalDate fecha_nacimiento;

    public Persona(int id_persona, String nombre, LocalDate fecha_nacimiento) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public abstract void registrar_usuario();
}

