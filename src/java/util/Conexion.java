/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** 
 *
 * @author hecto
 */
public class Conexion {
    private String driver,user,password,nombreBd,urlBd;
    private Connection conexion;
    
    public Conexion(){
        driver ="com.mysql.cj.jdbc.Driver";
        user="root";
        password="";
        nombreBd="ejerciciocarros4255";
        urlBd="jdbc:mysql://localhost:3306/"+nombreBd;
        
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlBd,user,password);
            System.out.print("ConexionOk");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.print("Error a conectar "+e.toString());
        }
    }
    
    public Connection ObtenerConexion(){
        return conexion;
    }
    public Connection CerrarConexion() throws SQLException{
        conexion.close();
        conexion = null;
        return conexion;
    }
    public static void main(String[] args){
        new Conexion();
    }
}
