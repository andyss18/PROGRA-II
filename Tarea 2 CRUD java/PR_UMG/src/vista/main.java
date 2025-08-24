/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;
import Modelo.Conexion;
/**
 *
 * @author itsan
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        FRM_PERSONA frm = new FRM_PERSONA();
        frm.show();
        Conexion cn=new Conexion();
        cn.abrir_conexion();
        cn.cerrar_conexion();
    }
    
}
