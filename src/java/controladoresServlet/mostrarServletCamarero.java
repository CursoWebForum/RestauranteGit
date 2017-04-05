package controladoresServlet;

import com.restaurante.utilidades.ConexionRestaurante;
import com.restaurante.utilidades.ExcepcionesBD;
import dao.camarero.restaurante.DaoCamarero;
import entidades.Camarero;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "mostrarServletCamarero", urlPatterns = {"/mostrarServletCamarero"})
public class mostrarServletCamarero extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {

            //ResultSet rs =DaoCamarero.verCamareros();
        ArrayList<Camarero> list_camarero = new ArrayList<Camarero>();
        list_camarero = (ArrayList<Camarero>) DaoCamarero.listarCamareros();
        //Comienza la respuesta
        response.setContentType("text/html;charset=UTF-8");
        //Queda pendiente hacerlo pero con objetos
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet mostrarServletCamarero</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Camareros en la lista </h1>");

            for (Camarero camarero : list_camarero) {
                out.println("<h1>Camareros en la lista </h1>");
                out.println("<p> Id camarero" + camarero.getIdCamarero() + "</p>");
                out.println("<p> Nombre:" + camarero.getNombre() + "</p>");
                out.println("<p>Apellido" + camarero.getApellido() + "</p>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mostrarServletCamarero.class.getName()).log(Level.SEVERE, null, ex);
            try {
                throw new ExcepcionesBD();
            } catch (ExcepcionesBD ex1) {
                Logger.getLogger(mostrarServletCamarero.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mostrarServletCamarero.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mostrarServletCamarero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(mostrarServletCamarero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
