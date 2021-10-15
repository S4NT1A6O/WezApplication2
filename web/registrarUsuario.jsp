<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta charset='utf-8'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registar Usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    </head>
    <body>
        <center>
             <div class="card col-md-6 justify-content-center" style="width: 400px;padding:50px ;margin-top: 200px;background-color:#ff9900; ">
            <h1>Registar Usuario</h1>
            <form method="POST" action="Usuario">
                <table>
                    <tr>
                        <label>Usuario:</label><br>
                        <input type="text" name="txtUsuario" required><br>
                        <label>Contraseña:</label><br>
                        <input type="password" name="txtClave"required><br>
                    </tr>
                </table>
                <br>
                <button class="btn btn-warning" style="color: white;text-align:center;">Registrarse</button><br><br>
                <input type="hidden" name="textOption" value="1">
                <input type="button" class="btn btn-warning" style="color: white;text-align:center;"value="Ya tienes cuenta? Inicia Sesión" onclick="location.href='index.jsp'"/>
            </form>
             </div> 
            <div style=" color: red;">
                <%
                  if(request.getAttribute("mensajeError") != null){%>
                   ${mensajeError}
                <%  }else{  %>
                   ${mensajeExito}
                <% } %>
            </div>
        </center>
    </body>
</html>
