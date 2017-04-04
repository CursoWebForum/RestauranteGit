/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.camarero.restaurante;

import com.restaurante.utilidades.ConexionRestaurante;
import com.restaurante.utilidades.ExcepcionesBD;
import controladoresServlet.ControladorServletCamarero;
import entidades.Camarero;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author martaperal
 */
//CRUD
////+ he añadido nuestro propio control de excepciones
public class DaoCamarero {
    
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DaoCamarero.class
			.getPackage().getName());

    
    /* public static void insertarCamareroCopy(int idCamarero, String nombre, String apellido) throws ExcepcionesBD {

        try {
            Connection conexion = ConexionRestaurante.conexionRestaurante();
            Statement sentencia = conexion.createStatement();
            String consultaSQL = "insert into camarero (idcamarero,nombre,apellido) values ";
            consultaSQL += "('" + idCamarero + "','" + nombre + "','" + apellido + "')";
            int filas = sentencia.executeUpdate(consultaSQL);
            System.out.println("Numero de filas insertadas: " + filas);
            sentencia.close();
            ConexionRestaurante.cerrarConexion();
        } catch (ClassNotFoundException e) {
            log.error("Clase no encontrada" + e.getMessage());
            throw new ExcepcionesBD("Clase no encontrada");
        } catch (SQLException e) {
           log.error("Excepción de Sql", e.getCause());
            throw new ExcepcionesBD("Se ha producido una excepción del tipo:" +e.getErrorCode());
        }

    }*/
    public static void insertarCamarero(int idCamarero, String nombre, String apellido) throws ExcepcionesBD {

        try {
            Connection conexion = ConexionRestaurante.conexionRestaurante();
            Statement sentencia = conexion.createStatement();
            String consultaSQL = "insert into camarero (idcamarero,nombre,apellido) values ";
            consultaSQL += "('" + idCamarero + "','" + nombre + "','" + apellido + "')";
            int filas = sentencia.executeUpdate(consultaSQL);
            log.info("Numero de Filas insertadas" + filas);
            sentencia.close();
            ConexionRestaurante.cerrarConexion();
        } catch (ClassNotFoundException e) {
            log.error("Clase no encontrada" + e.getMessage());
            throw new ExcepcionesBD("Clase no encontrada");
        } catch (SQLException e) {
            log.error("Excepción de Sql", e.getCause());
            throw new ExcepcionesBD("Se ha producido una excepción del tipo:" +e.getErrorCode());
        }

    }

    public static void actualizarCamarero(String nombre, String apellido, int idcamarero) throws ClassNotFoundException, SQLException {

        Connection conexion = ConexionRestaurante.conexionRestaurante();
        String sql = "update camarero SET nombre='"+nombre+"',apellido='"+apellido+"' WHERE idcamarero='"+idcamarero+"'";
        Statement actualizar = conexion.prepareStatement(sql);
        int filas = actualizar.executeUpdate(sql);
        System.out.println("N filas afectadas " + filas);
        actualizar.close();
        conexion.close();

    }

    //+ Orientacion de las listas a objetos
    //+ He eliminado el anterior metodo y añadido este
    public static ArrayList<Camarero> listarCamareros() throws ClassNotFoundException, SQLException  {
        
        
        Connection conexion = ConexionRestaurante.conexionRestaurante();
        String sql = "select idcamarero,nombre,apellido from camarero";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet rs = sentencia.executeQuery(sql);
        ArrayList<Camarero> lista_camareros = new ArrayList<Camarero>();
        try {
            while (rs.next()) {
                lista_camareros.add(new Camarero(Integer.parseInt(rs.getString("idcamarero")),
                        rs.getString("nombre"),
                        rs.getString("apellido")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ExcepcionesBD("error en la insercion de datos");
        }
        return lista_camareros;
    }
//  + nuevo metodo

    public static void borrarCamareroId(int idcamarero) throws ClassNotFoundException, SQLException {
        Connection conexion = ConexionRestaurante.conexionRestaurante();
        String consultaSQL = "delete from camarero where idcamarero='" + idcamarero + "'";
        Statement sentencia = conexion.prepareStatement(consultaSQL);
        int filas = sentencia.executeUpdate(consultaSQL);

    }

    //metodo que repite la tecnica de buscarTodo();
    //Aqui devolvemos un camarero
    //llenaremos el select y desde el haremos update, delete, read desde una 
    //unica pagina.. 
// + nuevo metodo
    public static Camarero buscarCamareroPorClave(String idcamarero) throws ClassNotFoundException, SQLException {

        String sql = "select idcamarero,nombre,apellido from camarero where='" + idcamarero + "'";

        Connection conexion = ConexionRestaurante.conexionRestaurante();
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet rs = sentencia.executeQuery(sql);
        ArrayList<Camarero> lista_camareros = new ArrayList<Camarero>();
        while (rs.next()) {
            lista_camareros.add(new Camarero(Integer.parseInt(rs.getString("idcamarero")),
                    rs.getString("nombre"),
                    rs.getString("apellido")));
        }

        return lista_camareros.get(0);

        //hay que crear su BO y su marca en el controlador
    }
// + nuevo metodo   

    public static void actualizarCamareroById(String nombre, String apellido, String idcamarero) throws ClassNotFoundException, SQLException {

        Connection conexion = ConexionRestaurante.conexionRestaurante();
        Statement sentencia = conexion.createStatement();
        String sql = "update camarero set titulo='" + nombre + "',apellido='" + apellido + "' where idcamarero='" + idcamarero + "'";
        int filas = sentencia.executeUpdate(sql);
        sentencia.close();
        conexion.close();
    }

}
