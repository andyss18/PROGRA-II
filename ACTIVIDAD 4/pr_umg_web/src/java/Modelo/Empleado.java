/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
/**
 *
 * @author ANDY
 */



public class Empleado extends Persona {
    Conexion cn = new Conexion();
    private String codigo;
    private int id,id_puesto;
    public Empleado() {
    }

    public Empleado(String codigo,int id,int id_puesto, String nombres, String apellidos, String direccion, int telefono, String fecha_nacimiento) {
        super(nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.codigo = codigo;
        this.id=id;
        this.id_puesto=id_puesto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    @Override
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
    try{
        cn=new Conexion();
        cn.abrir_conexion();
        String query = "select e.id_empleado as id,e.codigo,e.nombres,e.apellidos,e.direccion,e.telefono,e.fecha_nacimiento,concat(p.id_puesto,') ',p.puesto) as puesto from empleados as e inner join puestos as p on e.id_puesto = p.id_puesto;";
        ResultSet consulta= cn.conexionBD.createStatement().executeQuery(query);
        String encabezado[]= {"ID","CODIGO","NOMBRE","APELLIDOS","DIRECCION","TELEFONO","NACIMIENTO","PUESTO"};
        tabla.setColumnIdentifiers(encabezado);
        String datos[] = new String[8];
        while (consulta.next()){
            datos[0]=consulta.getString("id");
            datos[1]=consulta.getString("codigo");
            datos[2]=consulta.getString("nombres");
            datos[3]=consulta.getString("apellidos");
            datos[4]=consulta.getString("direccion");
            datos[5]=consulta.getString("telefono");
            datos[6]=consulta.getString("fecha_nacimiento");
            datos[7]=consulta.getString("puesto");     
            tabla.addRow(datos);
        }
        cn.cerrar_conexion();
        
    }catch(SQLException ex){
        System.out.println("Error : " + ex.getMessage());
    }
    return tabla;
    }

    public void crear(){
        try{
            PreparedStatement parametro;
            //cn = new Conexion();
            cn.abrir_conexion();
            String query = "INSERT INTO `bd_proof`.`empleados`(`codigo`,`nombres`,`apellidos`,`direccion`,`telefono`,`fecha_nacimiento`,`id_puesto`)"
                    + "VALUES(?,?,?,?,?,?,?);";
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getCodigo());
            parametro.setString(2, getNombres());
            parametro.setString(3, getApellidos());
            parametro.setString(4, getDireccion());
            parametro.setString(5, (String.valueOf(getTelefono())));
            parametro.setString(6, getFecha_nacimiento());
            parametro.setInt(7, getId_puesto());
            
            int ejecutar=parametro.executeUpdate();
            System.out.println("Se ingresó" + ejecutar + "registro");
            
            cn.cerrar_conexion();

        }catch(SQLException ex){
         System.out.println("error" + ex.getMessage());
        }
    
    }
    
    
    @Override
    public void actualizar(){
        try {
            PreparedStatement parametro;
            //cn = new Conexion();
            cn.abrir_conexion();
            // UPDATE `bd_proof`.`empleados` SET `direccion` = 'PETAPA' WHERE (`id_empleado` = '2');

            String query = "UPDATE `bd_proof`.`empleados` SET `codigo` = ?, `nombres` = ?, `apellidos` = ?, `direccion` = ?, `telefono` = ?, `fecha_nacimiento` = ?, `id_puesto` = ?"
                    + " WHERE (`id_empleado` = ?);";
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getCodigo());
            parametro.setString(2, getNombres());
            parametro.setString(3, getApellidos());
            parametro.setString(4, getDireccion());
            parametro.setString(5, (String.valueOf(getTelefono())));
            parametro.setString(6, getFecha_nacimiento());
            parametro.setInt(7, getId_puesto());
            parametro.setInt(8, getId());          

            int ejecutar = parametro.executeUpdate();
            System.out.println("Se actualizó" + ejecutar + "registro");

            cn.cerrar_conexion();

        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
    
    /**
     *
     */
    @Override
    public void eliminar(){
        try {
            PreparedStatement parametro;
            //cn = new Conexion();
            cn.abrir_conexion();
            String query = "DELETE FROM `bd_proof`.`empleados` WHERE (`id_empleado` = ?);";
            parametro= (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getId());

            int ejecutar = parametro.executeUpdate();
            System.out.println("Se eliminó" + ejecutar + "registro");
            JOptionPane.showMessageDialog(null, "se eliminaron" + ejecutar + "filas", "Atencion compa",JOptionPane.INFORMATION_MESSAGE);

            cn.cerrar_conexion();

        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
            JOptionPane.showMessageDialog(null,"error: " + ex, "error compa", JOptionPane.ERROR_MESSAGE);
            
        }
    }
}