/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import conexionbd.BD;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Override
    public void registrarTransaccion() {
        try (Connection con = new BD().establecerConexion()) {
            String query = "INSERT INTO MOVIMIENTOS (ID_USU, ID_PROC, TIPO_TRANSACCION, CANTIDAD, FECHA) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, this.id_usu);
            stmt.setInt(2, this.id_proc);
            stmt.setString(3, this.tipo_transaccion);
            stmt.setString(4, this.cantidad);
            stmt.setTimestamp(5, Timestamp.valueOf(this.fecha));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Transacción registrada correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la transacción");
        }
    }

    @Override
    public void obtenerDetallesTransaccion() {
        try (Connection con = new BD().establecerConexion()) {
            String query = "SELECT * FROM MOVIMIENTOS WHERE ID_TRANSACCION = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, this.id_transaccion);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
               this.id_transaccion=rs.getInt("ID_TRANSACCION");
                this.id_usu = rs.getInt("ID_USU");
                this.id_proc = rs.getInt("ID_PROC");
                this.tipo_transaccion = rs.getString("TIPO_TRANSACCION");
                this.cantidad = rs.getString("CANTIDAD");
                this.fecha = rs.getTimestamp("FECHA").toLocalDateTime();
                JOptionPane.showMessageDialog(null, "Detalles de la transacción obtenidos correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la transacción");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener detalles de la transacción");
        }
    }

    @Override
    public List<Movimientos> verHistorialTransacciones() {
        List<Movimientos> historial = new ArrayList<>();
        try (Connection con = new BD().establecerConexion()) {
            String query = "SELECT * FROM MOVIMIENTOS WHERE ID_USU = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, this.id_usu);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Movimientos movimiento = new Movimientos(
                    rs.getInt("ID_TRANSACCION"),
                    rs.getInt("ID_USU"),
                    rs.getInt("ID_PROC"),
                    rs.getString("TIPO_TRANSACCION"),
                    rs.getString("CANTIDAD"),
                    rs.getTimestamp("FECHA").toLocalDateTime()
                );
                historial.add(movimiento);
            }
            JOptionPane.showMessageDialog(null, "Historial de transacciones obtenido correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el historial de transacciones");
        }
        return historial;
    }
}

