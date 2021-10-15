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
import modeloVO.VehiculoVO;
import util.Conexion;
import util.Crud;
/**
 *
 * @author hecto
 */
public class VehiculoDAO extends Conexion implements Crud{
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion = false;
    private String sql;
    
    private String vehPlaca="",dataId="",cataId="",vehModelo="",vehMarca="",vehEstado="",vehPrecio="";
    
    public VehiculoDAO(VehiculoVO vehiVO){
        super();
        try{
            conexion = this.ObtenerConexion();
            vehPlaca = vehiVO.getVehPlaca();
            dataId = vehiVO.getDataId();
            cataId = vehiVO.getCataId();
            vehModelo = vehiVO.getVehModelo();
            vehMarca = vehiVO.getVehMarca();
            vehEstado = vehiVO.getVehEstado();
            vehPrecio = vehiVO.getVehPrecio();
        }catch (Exception e){
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE,null,e);
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "INSERT INTO vehiculo(vehPlaca,dataId,cataId,vehModelo,vehMarca,vehEstado,vehPrecio)VALUES(?,?,?,?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, vehPlaca);
            puente.setString(2, dataId);
            puente.setString(3, cataId);
            puente.setString(4, vehModelo);
            puente.setString(5, vehMarca);
            puente.setString(6, vehEstado);
            puente.setString(7, vehPrecio);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try{
                this.CerrarConexion();
            }catch(SQLException ex){
                Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return operacion;
    }

    @Override
    public boolean actuializarRegistro() {
        try {
            sql = "UPDATE vehiculo SET "
                    + "dataId=?,"
                    + "cataId=?,"
                    + "vehModelo=?,"
                    + "vehMarca=?,"
                    + "vehEstado=?,"
                    + "vehPrecio=?,"
                    + "WHERE vehPlaca=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, vehPlaca);
            puente.setString(2, dataId);
            puente.setString(3, cataId);
            puente.setString(4, vehModelo);
            puente.setString(5, vehMarca);
            puente.setString(6, vehEstado);
            puente.setString(7, vehPrecio);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        try {
            sql = "DELETE FROM vehiculo WHERE vehPlaca = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, vehPlaca);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return operacion;
    }
}
