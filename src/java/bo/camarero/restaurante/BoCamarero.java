/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.camarero.restaurante;

import dao.camarero.restaurante.DaoCamarero;
import static dao.camarero.restaurante.DaoCamarero.insertarCamarero;
import entidades.Camarero;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author martaperal
 */
public class BoCamarero {
    
    
    public static void procesarPeticionUpdateCamareroById(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
        
    Camarero camarero=new Camarero();
    camarero.setNombre(request.getParameter("nombre"));
    camarero.setApellido(request.getParameter("apellido"));
    camarero.setIdCamarero(Integer.parseInt(request.getParameter("idcamarero")));
    DaoCamarero.actualizarCamarero(camarero.getNombre(),camarero.getApellido(),camarero.getIdCamarero());
    
    
    }
    
    public static void procesarPeticionInsertarCamarero(HttpServletRequest request,HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException{
    //orientacion a objetos
    Camarero camarero=new Camarero();
    camarero.setIdCamarero(Integer.parseInt(request.getParameter("idcamarero")));
    camarero.setNombre(request.getParameter("nombre"));
    camarero.setApellido(request.getParameter("apellido"));
    DaoCamarero.insertarCamarero(camarero.getIdCamarero(), camarero.getNombre(), camarero.getApellido());
    
 
     

}
    public static void procesarPeticionBorrarCamareroById(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
        Camarero camarero=new Camarero();
        camarero.setIdCamarero(Integer.parseInt(request.getParameter("idcamarero")));
        DaoCamarero.borrarCamareroId(camarero.getIdCamarero());
       
    }
    
    public static void procesarPeticiónListarCamarero(HttpServletRequest request,HttpServletResponse response){
        
        try {
            Camarero camarero=new Camarero();
            DaoCamarero.listarCamareros();
            //cambiar los loooger
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BoCamarero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BoCamarero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
