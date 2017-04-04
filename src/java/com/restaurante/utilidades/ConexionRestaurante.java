package com.restaurante.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class ConexionRestaurante {

    private static Connection conexion;

    //private final static Logger log = Logger.getLogger(ConexionRestaurante.class);
    private static final Logger log = Logger.getLogger(ConexionRestaurante.class.getPackage().getName());

    public static Connection conexionRestaurante() throws ClassNotFoundException, SQLException {

        //BasicConfigurator.configure();
        String classname = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/resturante";
        String user = "root";
        String password = "root";

        Class.forName(classname);
        conexion = DriverManager.getConnection(url, user, password);

        if (conexion != null) {

            log.debug("Conexion establecida" + conexion);
        } else {

            log.error("---Se ha producido un error en la conexion---");

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
