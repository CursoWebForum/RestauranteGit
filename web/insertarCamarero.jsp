<%-- 
    Document   : insertarCamarero
    Created on : 02-mar-2017, 11:00:08
    Author     : martaperal
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    String nombre=request.getParameter("nombre");
    String apellido=request.getParameter("apellido");
    String idcamarero=request.getParameter("idcamarero");
    //---
    Connection conexion=null;
    Statement sentencia=null;
    //---
    String className="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://RAUL/resturante";
    String user="root";
    String password="root";
   //----
    
    Class.forName(className);
    conexion=DriverManager.getConnection("jdbc:mysql://localhost/resturante", "root",
				"root");
    
    if(conexion!=null){
        System.out.println("Conexion Establecida");
        
    }
    //----
    sentencia=conexion.createStatement();
    //----
    String consultaSQL = "insert into camarero (idcamarero,nombre,apellido) values ";
		consultaSQL += "('" + idcamarero + "','" + nombre + "','" +apellido+ "')";
    
                
    //--            
    sentencia.executeUpdate(consultaSQL);
    sentencia.close();
    conexion.close();
    //---
    response.sendRedirect("mostrarCamarero.jsp");
    
    







%>
