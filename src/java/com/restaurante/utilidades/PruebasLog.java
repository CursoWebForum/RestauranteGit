/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.utilidades;

import java.sql.SQLException;

/**
 *
 * @author martaperal
 */
public class PruebasLog {

   
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        ConexionRestaurante.conexionRestaurante();
        ConexionRestaurante.cerrarConexion();
        
    }
    
}
