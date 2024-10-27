/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1;
import java.util.List;
/**
 *
 * @author Usuario
 */
public interface  IMovimientos {
    
    void registrarTransaccion();
    
    void obtenerDetallesTransaccion();
    
    List <Movimientos> verHistorialTransacciones();
    
}
