package controladoresServlet;

import com.restaurante.utilidades.ConexionRestaurante;
import bo.camarero.restaurante.BoCamarero;
import dao.camarero.restaurante.DaoCamarero;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.BasicConfigurator;

@WebServlet (name="ControladorServletCamarero", urlPatterns = {"/controladorServletCamarero"})
public class ControladorServletCamarero extends HttpServlet {

    //Nuestro Controlador llama a la vista
    private static final Logger logCamarero = Logger.getLogger(ControladorServletCamarero.class.getPackage().getName());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        
         
        HttpSession misession = (HttpSession) request.getSession();
       
        boolean log = (boolean) misession.getAttribute("ok");
        String action = request.getParameter("action");
        logCamarero.info("usuario registrado");

        if (log == true) {

            //recupera el action del formulario
            if (action.contains("actualizar")) {

                BoCamarero.procesarPeticionUpdateCamareroById(request, response);
                response.sendRedirect("/mostrarCamarero.jsp");
                 /*RequestDispatcher rs=request.getRequestDispatcher("mostrarCamarero.jsp");
                 rs.forward(request, response);*/
            }
            if (action.contains("insertar")) {
                BoCamarero.procesarPeticionInsertarCamarero(request, response);
               
               
                response.sendRedirect("/mostrarCamarero.jsp");
            }
            
            if (action.contains("borrar")) {
                BoCamarero.procesarPeticionBorrarCamareroById(request, response);
                response.sendRedirect("/mostrarCamarero.jsp");
            }
            
            if(action.contains("listar")){
                
                BoCamarero.procesarPeticiónListarCamarero(request, response);
                
                response.sendRedirect("/mostrarCamarero.jsp");
                
            }

        }
            
         //si el usuario no esta loegado hace el else{}
        response.sendRedirect("/RestauranteGit/login.html");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorServletCamarero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorServletCamarero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorServletCamarero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorServletCamarero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
