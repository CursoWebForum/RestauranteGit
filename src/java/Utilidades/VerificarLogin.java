/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import controladoresServlet.LogRestaurante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author martaperal
 */
public class VerificarLogin {

    private final static org.apache.log4j.Logger logVerificarLogin = org.apache.log4j.Logger.getLogger(VerificarLogin.class);

    public static boolean comprobarLogin(String usuario, String password) throws ClassNotFoundException, SQLException {

        BasicConfigurator.configure();

        boolean nRegistro = false;
        String sql = "select * from logeados where usuario='" + usuario + "' AND password='" + password + "'";
        Connection con = ConexionRestaurante.conexionRestaurante();
        PreparedStatement comprobarLogin = con.prepareStatement(sql);
        
        ResultSet rs = comprobarLogin.executeQuery(sql);
        
        if (rs.next()) {
            // si devuelve resultados el login es correcto 
            nRegistro = true;
            ConexionRestaurante.cerrarConexion();

        }

        return nRegistro;

    }

}
