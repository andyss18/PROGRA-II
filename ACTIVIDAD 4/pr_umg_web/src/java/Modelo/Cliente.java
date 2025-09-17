/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Modelo.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author itsan
 */
public class Cliente extends Persona {
    private String nit;
    private int id;
    Conexion cn = new Conexion();
    public Cliente() {
    }

    public Cliente(int id,String nit, String nombres, String apellidos, String direccion, int telefono, String fecha_nacimiento) {
        super(nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.nit = nit;
        this.id=id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    @Override
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
    try{
        cn.abrir_conexion();
        String query = "select c.id_cliente as id,c.nit,c.nombres,c.apellidos,c.direccion,c.telefono,c.fecha_nacimiento from clientes as c;";
        ResultSet consulta= cn.conexionBD.createStatement().executeQuery(query);
        String encabezado[]= {"ID","nit","NOMBRE","APELLIDOS","DIRECCION","TELEFONO","NACIMIENTO"};
        tabla.setColumnIdentifiers(encabezado);
        String datos[] = new String[7];
        while (consulta.next()){
            datos[0]=consulta.getString("id");
            datos[1]=consulta.getString("nit");
            datos[2]=consulta.getString("nombres");     
            datos[3]=consulta.getString("apellidos");
            datos[4]=consulta.getString("direccion");
            datos[5]=consulta.getString("telefono");
            datos[6]=consulta.getString("fecha_nacimiento");    
            tabla.addRow(datos);
        }
        cn.cerrar_conexion();
        
    }catch(SQLException ex){
        System.out.println("Error : " + ex.getMessage());
    }
    return tabla;
    }
    
    
    @Override
    public void Crear(){
            try{
            PreparedStatement parametro;
            cn.abrir_conexion();
            String query = "INSERT INTO `bd_proof`.`clientes`(`nit`,`nombres`,`apellidos`,`direccion`,`telefono`,`fecha_nacimiento`)"
                    + "VALUES(?,?,?,?,?,?);";
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getNit());
            parametro.setString(2, getNombres());
            parametro.setString(3, getApellidos());
            parametro.setString(4, getDireccion());
            parametro.setString(5, (String.valueOf(getTelefono())));
            parametro.setString(6, getFecha_nacimiento());
            
            
            int ejecutar=parametro.executeUpdate();
            System.out.println("Se ingresó" + ejecutar + "registro");
            
            cn.cerrar_conexion();
            

        }
        catch(Exception ex){
            System.out.println("error" + ex.getMessage());
            //return false;sa
        } 
    }
    
    @Override
    public void actualizar() {

        try {
            PreparedStatement parametro;
            cn.abrir_conexion();
            String query = "UPDATE `bd_proof`.`clientes` "
                    + "SET `nit` = ?, `nombres` = ?, `apellidos` = ?, "
                    + "`direccion` = ?, `telefono` = ?, `fecha_nacimiento` = ? "
                    + "WHERE `id_cliente` = ?;";
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getNit());
            parametro.setString(2, getNombres());
            parametro.setString(3, getApellidos());
            parametro.setString(4, getDireccion());
            parametro.setString(5, (String.valueOf(getTelefono())));
            parametro.setString(6, getFecha_nacimiento());
            parametro.setInt(7, getId());

            int ejecutar = parametro.executeUpdate();


            cn.cerrar_conexion();
            System.out.println("Se Actualizó " + ejecutar + " registro");

        } catch (Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
        
    }
    
    @Override
    public void eliminar() {
        
        try {
            PreparedStatement parametro;
            cn.abrir_conexion();
            String query = "DELETE FROM `bd_proof`.`clientes` WHERE (`id_cliente` = ?);";
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getId());

            int ejecutar = parametro.executeUpdate();

            cn.cerrar_conexion();
            System.out.println("Se eLIMINO " + ejecutar + " registro");

        } catch (Exception ex) {
            System.out.println("error" + ex.getMessage());
        }

    }


}


    


