/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
import java.time.LocalDateTime;
import java.util.List;

public class Movimientos implements IMovimientos {
    private int id_transaccion;
    private int id_usu;
    private int id_proc;
    private String tipo_transaccion;
    private String cantidad;
    private LocalDateTime fecha;

    public Movimientos(int id_transaccion, int id_usu, int id_proc, String tipo_transaccion, String cantidad, LocalDateTime fecha) {
        this.id_transaccion = id_transaccion;
        this.id_usu = id_usu;
        this.id_proc = id_proc;
        this.tipo_transaccion = tipo_transaccion;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public int getId_proc() {
        return id_proc;
    }

    public void setId_proc(int id_proc) {
        this.id_proc = id_proc;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }


    @Override
    public void registrarTransaccion() {
        // registrar una transacción
    }

    @Override
    public void obtenerDetallesTransaccion() {
        // obtener detalles de una transacción
    }

    @Override
    public List<Movimientos> verHistorialTransacciones() {
        //  ver historial de transacciones
        return null;
    }
}
