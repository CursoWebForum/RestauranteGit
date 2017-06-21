<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Camarero</title>
        <link href="css/estilosResturante.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <img id="restaurante" src="images/restaurantes.jpg" alt="Me voy para alla" title="¿ Esto es un chino?"/>
        <form id="altaCocinero" action="/Restaurante/formularioServletCocinero" method="POST">
            <fieldset> 
                <legend>Alta Cocineros</legend>
                <p>
                    <label for="idCocnero">Codigo Cocinero</label>
                    <input id="idCocinero" type="text" name="idcocinero"/>
                </p>

                <p>
                    <label for="nombre">Nombre Camarero</label>
                    <input id="nombre" type="text" name="nombre" />
                </p>
                <p>
                    <label for="apellido">Apellido Camarero</label>
                    <input id="apellido" type="text" name="apellido"/>
                </p>
                <input type="submit" value="Enviar" name="btnGuardar" />
            </fieldset>
        </form>
    </body>
</html>
