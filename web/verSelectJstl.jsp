<%-- 
    Document   : verSelect
    Created on : 24-mar-2017, 13:21:53
    Author     : martaperal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Camarero"%>
<%@page import="dao.camarero.restaurante.DaoCamarero"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Select</title>
    </head>
    
        <h1>Comprobar Select</h1>
        <jsp:useBean class="dao.camarero.restaurante.DaoCamarero" id="daoCamarero" scope="page"/>
        <jsp:useBean id="camarero" class="entidades.Camarero" scope="page"/>       
        <form id="borrarCamarero" action="RestauranteGit/controladorServletCamarero">
            <select name="idcamarero">
             
              
                <c:forEach var="camarero" items="${daoCamarero.listarCamareros()}">
                    
                    ${camarero.apellido}

                    

                </c:forEach>

            </select>
            <input type="hidden" name="action" value="borrar">
            <input type="submit" name="Borrar" value="Borrar"/>
        </form>
        <a href="registroCamarero.html">Alta Camarero</a>
    
</html>
</body>
</html>
