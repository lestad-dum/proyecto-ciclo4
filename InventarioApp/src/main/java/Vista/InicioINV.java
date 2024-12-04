package Vista;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.SwingUtilities;

public class InicioINV{

    public static void main(String [] args){
        SwingUtilities.invokeLater(()-> {
            Login log = new Login();
            log.setVisible(true);
        });
    }
}
