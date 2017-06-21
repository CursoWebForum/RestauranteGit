

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Libros</title>
    </head>
    <body>
        <%
            Connection conexion = null;
            Statement sentencia = null;
            ResultSet rs = null;
            String className = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://RAUL/resturante";
            String user = "root";
            String password = "root";

            Class.forName(className);
            conexion = DriverManager.getConnection(
				"jdbc:mysql://localhost/resturante", "root",
				"root");

            if (conexion != null) {
                System.out.println("Conexion Establecida");

            }
            //----
            sentencia = conexion.createStatement();
            String consultaSQL = "select idcamarero,nombre,apellido from camarero";
            rs = sentencia.executeQuery(consultaSQL);
            while(rs.next()){%>
            
              <p><%=rs.getString("idcamarero")%></p>
              <p><%=rs.getString("nombre")%></p>
              <p><%=rs.getString("apellido")%></p>
        <hr/>
            
            
                <%}%>
         <a href="FormularioCamarero.jsp">Insertar Libro</a>
    </body>
</html>