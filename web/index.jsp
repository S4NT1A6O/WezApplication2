<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset='utf-8'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesion</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        
    </head>
    <body>
        <center>            
            <div class="card col-md-4" style="width:375px; height:350px; padding:40px ;margin-top: 40px;background-color:#FF5733;">
                <h2>Login</h2>
            <form method="POST" action="Usuario">
                <table>
                    <tr>
                        <label style="margin-top: 15px">Usuario</label><br>
                        <input type="text" style="border-radius:5px; width: 100%;" name="txtUsuario"required><br>
                        <label style="margin-top: 15px">Contraseña</label><br>
                        <input type="password" style="border-radius:5px; width: 100%;" name="txtClave"required><br>
                    </tr>
                </table>
                <br>
                <button class="btn btn-warning" style="color: white; background-color:#FFA07A; border: none; text-align:center;">Ingresar</button><br><br>
                <input type="hidden" name="textOption" value="4">
                <input type="button" class="btn btn-warning" style="color: white; background-color:#FFA07A; border: none; text-align:center;"value="Registrarse..." onclick="location.href='registrarUsuario.jsp'"/>
            </form>
            </div>    
            <div style=" color: red;">
                <%if(request.getAttribute("mensajeError") != null){%>
                   ${mensajeError}
                <%}else{%>
                   ${mensajeExito}
                <%}%>
            </div>
        </center>
    </body>
</html>
