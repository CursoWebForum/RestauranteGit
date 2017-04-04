/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladoresServlet;

import com.restaurante.utilidades.ConexionRestaurante;
import com.restaurante.utilidades.VerificarLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.BasicConfigurator;

@WebServlet(name = "LogRestaurante", urlPatterns = {"/logRestaurante"})
public class LogRestaurante extends HttpServlet {

    private final static org.apache.log4j.Logger logRestaurante = org.apache.log4j.Logger.getLogger(LogRestaurante.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        
        BasicConfigurator.configure();
        
        String user_login = request.getParameter("login_usuario");
        String pass_login = request.getParameter("login_password");
        
        
        
        boolean verificarUsuario = VerificarLogin.comprobarLogin(user_login, pass_login);
        

        if (verificarUsuario == true) {
               

            HttpSession sesion_login = request.getSession();
            
            logRestaurante.debug("Sesion Creada: "+sesion_login.isNew());
            
            sesion_login.setAttribute("login_usuario", user_login);
            sesion_login.setAttribute("login_password", pass_login);
            sesion_login.setAttribute("ok", verificarUsuario);

            response.sendRedirect("/RestauranteGit/altas.htm");
        } else {

            response.sendRedirect("/RestauranteGit/login.html");

        }

        /*response.setContentType("text/html;charset=UTF-8");
         try (PrintWriter out = response.getWriter()) {
            
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet LogRestaurante</title>");            
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>Servlet LogRestaurante at " + request.getContextPath() + "</h1>");
         out.println("</body>");
         out.println("</html>");
         }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogRestaurante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LogRestaurante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogRestaurante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LogRestaurante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
