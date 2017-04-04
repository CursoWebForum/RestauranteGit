/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.admistrador.restaurante;

import com.restaurante.utilidades.ConexionRestaurante;
import static dao.camarero.restaurante.DaoCamarero.insertarCamarero;
import entidades.Administrador;
import entidades.Camarero;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author martaperal
 */
public class DaoAdministrador {
    
    public static void insertarAdministrador(String usuario, String password,String nombre_administrador, String apellido_administrador) throws ClassNotFoundException, SQLException{
        
      Connection conexion=ConexionRestaurante.conexionRestaurante();
      String consultaSQL = "insert into logeados (usuario,password,nombre_administrador,apellido_administrador) values ";
      consultaSQL += "('" + usuario + "','" + password + "','" + nombre_administrador + "','" + apellido_administrador + "')";
      Statement sentencia=conexion.createStatement();
      int filas=sentencia.executeUpdate(consultaSQL);
      System.out.println("Registro insertado Correctamente"+filas);
      sentencia.close();
      ConexionRestaurante.cerrarConexion();
      
    }
    
    public static void procesarPeticionAdministrador(HttpServletRequest request,HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException{
    //orientacion a objetos
    Administrador administrador=new Administrador();
    
    administrador.setNombreAdministrador(request.getParameter("nombre_administrador"));
    administrador.setApellidoAdministrador(request.getParameter("apellido_administrador"));
    administrador.setUsuarioAdministrador(request.getParameter("usuario_administrador"));
    administrador.setPasswordAdministrador(request.getParameter("password_administrador"));
    
    insertarAdministrador(administrador.getUsuarioAdministrador(),administrador.getPasswordAdministrador(),administrador.getNombreAdministrador(),administrador.getApellidoAdministrador());
    response.sendRedirect("/RestauranteGit/login.html");
     

}
    
}
