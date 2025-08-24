/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;



/**
 *
 * @author itsan
 */
public class Puesto {
    Conexion cn;
    
    private int id;
    private String puesto;

    public Puesto (){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
            

    
    
    public DefaultComboBoxModel leer(){
        
        DefaultComboBoxModel combo= new DefaultComboBoxModel();
        try{
            cn = new Conexion();
            cn.abrir_conexion();
            String query= "Select id_puesto as id,puesto from puestos;";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            combo.addElement("0) Elija puesto");
            while(consulta.next()){
                combo.addElement(consulta.getString("id") + ") " + consulta.getString("puesto"));
                
            }
        } catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return combo;
    }
}

