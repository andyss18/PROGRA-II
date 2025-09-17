/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Programador
 */
public class Puesto {
    Conexion cn;
    private String puesto;
    private int id,id_puesto;

    public Puesto() {
    }

    public Puesto(String puesto, int id, int id_puesto) {
        this.puesto = puesto;
        this.id = id;
        this.id_puesto = id_puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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
    
    public HashMap leer(){
     HashMap<String,String> drop  = new HashMap(); // llave, valor
     try{
         cn  = new Conexion();
         cn.abrir_conexion();
         String query = "select id_puesto,puesto from puestos;";
         ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
                
            while(consulta.next()){
                drop.put(consulta.getString("id_puesto"), consulta.getString("puesto"));
            }
         cn.cerrar_conexion();
     }catch(SQLException ex){
       System.out.println("Error: " + ex.getMessage());
     }
     return drop;
    }
}
