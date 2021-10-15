/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.UsuarioVO;
import util.Conexion;
import util.Crud;

/**
 *
 * @author hecto
 */
public class UsuarioDAO extends Conexion implements Crud{
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion = false;
    private String sql;
    
    private String usuId="",usuLogin="",usuPassword="";
    
    public UsuarioDAO(UsuarioVO usuVO){
        super();
        try{
            conexion = this.ObtenerConexion();
            usuId = usuVO.getUsuId();
            usuLogin = usuVO.getUsuLogin();
            usuPassword = usuVO.getUsuPassword();
        }catch (Exception e){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "INSERT INTO usuario(usuLogin,usuPassword)VALUES(?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try{
                this.CerrarConexion();
            }catch(SQLException ex){
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return operacion;
    }

    @Override
    public boolean actuializarRegistro() {
        try {
            sql = "UPDATE usuario SET "
                    + "usuLogin=?,"
                    + "usuPassword=?,"
                    + "WHERE USUID=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.setString(3, usuId);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try{
                this.CerrarConexion();
            }catch(SQLException ex){
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        try {
            sql = "DELETE FROM usuario WHERE usuId = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuId);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try{
                this.CerrarConexion();
            }catch(SQLException ex){
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return operacion;
    }
    
    public boolean iniciarSesion(String usuario, String clave){
        try{
            conexion = this.ObtenerConexion();
            sql = "SELECT * FROM usuario WHERE usuLogin = ? and usuPassword = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            puente.setString(2, clave);
            mensajero = puente.executeQuery();
            if (mensajero.next()){
                operacion = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try{
                this.CerrarConexion();
            }catch(SQLException ex){
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return operacion;
    }
    
}
