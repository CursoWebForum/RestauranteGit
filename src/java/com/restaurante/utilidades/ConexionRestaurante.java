package com.restaurante.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class ConexionRestaurante {

    private static Connection conexion;

    private static final Logger log = Logger.getLogger(ConexionRestaurante.class.getPackage().getName());

    public static Connection conexionRestaurante() {

        String classname = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/resturante";
        String user = "root";
        String password = "root";
        try {

            Class.forName(classname);
            conexion = DriverManager.getConnection(url, user, password);

        } 
        catch (ClassNotFoundException ex) {

            throw new ExcepcionesBD("Revisa tu classname", ex);

        } catch (SQLException ex) {

            log.error("---Se ha producido un error en la conexion---", ex);

        }
        if (conexion != null) {

            log.info("--Conexion establecida--");

        }

        return conexion;
    }

    public static void cerrarConexion() throws ClassNotFoundException, SQLException {

        if (conexion != null) {
            conexion.close();

            log.info("Conexion Cerrada");

        } else {

            log.error("Se ha producido un error en la conexion");

        }

    }
}
