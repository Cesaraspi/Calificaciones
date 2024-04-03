<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.Estudiante"%>
<%
    if (session.getAttribute("listaper")== null){
    ArrayList<Estudiante> lisaux = new ArrayList<Estudiante>();
    session.setAttribute("listaper", lisaux);
    }
    ArrayList<Estudiante> lista =(ArrayList<Estudiante>) session.getAttribute("listaper");
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>PRIMER PARCIAL TEM-742</h2>
        <h3>Nombre: Cesar David Aspi Sonco</h3>
        <h3>Carnet:7097025</h3>
        <h1>Registro de calificaciones</h1>
        <a href="MainServlet?op=nuevo">Nuevo</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombres</th>
                <th>P1(30)</th>
                <th>P2(30)</th>
                <th>EF(30)</th>
                <th>Nota</th>
                <th></th>
                <th></th>
            </tr>
            <tr>
                <%
                    if (lista != null){
                    for(Estudiante item : lista){
                    %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getNombres()%></td>
                <td><%= item.getP1() %></td>
                <td><%= item.getP2() %></td>
                <td><%= item.getEF() %></td>
                <td><%= item.getNota() %></td>
                <td>
                    <a href="MainServlet?op=editar&id=<%= item.getId() %>"
                       onclick="return(confirm('Desea editar???'))"
                       >Editar</a>
                    
                </td>
                <td>
                    <a href="MainServlet?op=eliminar&id=<%= item.getId() %>"
                     onclick="return(confirm('Esta seguro de eliminar??'))"  
                       >Eliminar</a>
                </td>
            </tr>
            <%
                
                    }
                    }
                 %>
                    
               
                
        </table>
    </body>
</html>
