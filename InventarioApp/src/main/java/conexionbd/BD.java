package conexionbd;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class BD {
    
    Connection conectar = null;
    
    String usuario = "lestad";
    String contrasenia = "Cr7goat2024";
    String bd="RADIOSHACK1";
    String ip="localhost";
    String puerto="1454";
    
    String cadena="jdbc:sqlserver://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexion(){
    
    try{
     String cadena = "jdbc:sqlserver://localhost:1454;databaseName=RADIOSHACK1;encrypt=false;trustServerCertificate=true";      
     conectar=DriverManager.getConnection(cadena,usuario,contrasenia);
        JOptionPane.showMessageDialog(null, "Se conecto correctamente a la Base de Datos");
    } catch (Exception e){
        JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos, error:" + e.toString());
    }
    return conectar;
    }
}
