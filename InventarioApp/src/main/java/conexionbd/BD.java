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
    String puerto="1433";
    
    String cadena="jdbc:sqlserver://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexion(){
    
    try{
     String cadena = "jdbc:sqlserver://localhost:1433;databaseName=RADIOSHACK1;encrypt=false;trustServerCertificate=true";      
     conectar=DriverManager.getConnection(cadena,usuario,contrasenia);
       System.out.println("Se conecto correctamente a la Base de Datos");
    } catch (Exception e){
        System.out.println("Fallo en conectarse a la Base de datos");
    }
    return conectar;
    }
}
