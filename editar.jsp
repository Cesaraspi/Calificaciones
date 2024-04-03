<%@page import="com.emergentes.Estudiante"%>
<%
    Estudiante reg = (Estudiante) request.getAttribute("miobjper");
    
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Registro de calificaciones</h1>
        <form action="MainServlet" method="post">
            <table>
               <tr>
                    <td>ID</td>
                    <td><input type="text" name="id" value="<%=reg.getId() %>" size="2" readonly=""></td>
                </tr>
                 <tr>
                    <td>Nombre del estudiante:</td>
                    <td><input type="text" name="nombres" value="<%=reg.getNombres() %>"></td>
                </tr>
                
                 <tr>
                    <td>Primer parcial(sobre 30 pts):</td>
                    <td><input type="text" name="p1" value="<%=reg.getP1() %>"></td>
                </tr>
                <tr>
                    <td>Segundo parcial(sobre 30 pts):</td>
                    <td><input type="text" name="p2" value="<%=reg.getP2() %>"></td>
                </tr><!-- comment -->
                <tr>
                    <td>Examen final(sobre 40 pts):</td>
                    <td><input type="text" name="EF" value="<%=reg.getEF() %>"></td>
                </tr>
                
               
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"></td>
                </tr>
            </table>
            
        </form>
    </body>
</html>
