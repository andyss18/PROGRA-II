/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Modelo.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author itsan
 */
public class Conexion {
    public Connection conexionBD;
    public final String puerto = "3306";
    public final String bd = "bd_proof";
    public final String urlConexion = String.format("jdbc:mysql://localhost:%s/%s?serverTimezone=UTC", puerto, bd);
    public final String usuario = "root";
    public final String contra = "andy@19jajaj";
    public final String jdbc = "com.mysql.cj.jdbc.Driver";
    
    public void abrir_conexion(){
    try{
        Class.forName(jdbc);
        conexionBD = DriverManager.getConnection(urlConexion,usuario,contra);
        System.out.println("Conexion Exitosa...");
    }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error: " + ex.getMessage());
    }
    }
    
    public void cerrar_conexion(){
        try{
            conexionBD.close();
        }catch(SQLException ex){
         System.out.println("Error" + ex.getMessage());
        }
    
    }
}
