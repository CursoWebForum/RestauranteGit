/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.cocinero.restaurante;

import com.restaurante.utilidades.ConexionRestaurante;
import entidades.Cocinero;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author martaperal
 */
public class DaoCocinero {
    
    public static ResultSet verCocineros() throws ClassNotFoundException, SQLException{
    
    Connection conexion=ConexionRestaurante.conexionRestaurante();
    Statement sentencia = conexion.createStatement();
    String consultaSQL = "select idcocinero,nombre,apellido from cocinero";
    ResultSet lista_cocineros=sentencia.executeQuery(consultaSQL);
    
    return lista_cocineros;
}



public static void insertarCocinero(int idCocinero,String nombre,String apellido) throws ClassNotFoundException, SQLException{
    
    Connection conexion=ConexionRestaurante.conexionRestaurante();
    Statement sentencia=conexion.createStatement();
    String consultaSQL = "insert into cocinero (idcocinero,nombre,apellido) values ";
    consultaSQL += "('" + idCocinero + "','" + nombre + "','" + apellido + "')";
    sentencia.executeUpdate(consultaSQL);
    sentencia.close();
    ConexionRestaurante.cerrarConexion();
}


    
}
