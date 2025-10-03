/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.PreparedStatement;
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

    public Cliente(int id, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento, String nit) {
        super(id, nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.nit = nit;
        this.id = id;
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
    public DefaultTableModel mostrar(){
        DefaultTableModel tabla = new DefaultTableModel();
    try{

        
    }catch(Exception ex){

    }
    return tabla;
    }
    
    
    @Override
    public int agregar(){
            try{

            

        }
        catch(Exception ex){

        } 
        return 0;
    }
    
    @Override
    public int modificar() {

        try {


        } catch (Exception ex) {

        }
        return 0;
    }
    
    @Override
    public int eliminar() {
        
        try {


        } catch (Exception ex) {

        }
        return 0;   
    }


}


    


