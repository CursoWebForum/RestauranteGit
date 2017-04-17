<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<sql:setDataSource dataSource="universidad"></sql:setDataSource>
<sql:query var="profesores">
    select * from profesor
</sql:query>
<html>
  <head>
    <title>Sistema Universitario</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <h1>Sistema Universitario</h1>
  <h2>Listado de profesores</h2>
  <table>
    <thead>
    <tr><th>Cedula</th><th>Nombre</th>
    <th>Titulo</th><th>Acciones</th></tr>
    </thead>
    <tbody>
    <c:forEach var="profesor" begin="0" items="${profesores.rows}">
       <tr><td>${profesor.cedula}</td>
        <td>${profesor.nombre}</td>
        <td>${profesor.titulo}</td>
        <td><a href='/detalleProfesor.jsp?id=${profesor.id}'>
              <input type="submit" value="Detalle"/></a>
            <a href='/eliminarProfesor.jsp?id=${profesor.id}'>
              <input type="submit" value="Eliminar"/></a></td></tr>
    </c:forEach>
   </tbody>
   <tfoot>
    <tr><td><a href='/agregarProfesor.jsp'>
        <input type="submit" name="action" value="Agregar"/></a>
    </td><td></td><td></td><td></td></tr>
   </tfoot>
  </table>
</html>
