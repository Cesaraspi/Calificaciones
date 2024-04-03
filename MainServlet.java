package com.emergentes.controlador;

import com.emergentes.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op =request.getParameter("op");
        Estudiante objper = new Estudiante();
        int  id, pos;
        
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>)ses.getAttribute("listaper");
        switch (op){
            case "nuevo":
                request.setAttribute("miobjper", objper);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request, id);
                objper = lista.get(pos);
                 request.setAttribute("miobjper", objper);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                 pos = buscarPorIndice(request, id);
                 if (pos >= 0){
                     lista.remove(pos);
                 }
                 request.setAttribute("listaper", lista);
                 response.sendRedirect("index.jsp");
                break;
            default:
        }
        
    }
       
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("id"));
       HttpSession ses = request.getSession();
       ArrayList<Estudiante> lista = (ArrayList<Estudiante>)ses.getAttribute("listaper");
       Estudiante objper = new Estudiante();
       objper.setId(id);
       objper.setNombres(request.getParameter("nombres"));
       
       objper.setP1(Integer.parseInt(request.getParameter("p1")));
       objper.setP2(Integer.parseInt(request.getParameter("p2")));
       objper.setEF(Integer.parseInt(request.getParameter("EF")));
       int Nota = (Integer.parseInt(request.getParameter("p2")))+(Integer.parseInt(request.getParameter("p1")))+(Integer.parseInt(request.getParameter("EF")));
       objper.setNota(Nota);
       if (id == 0){
           int idNuevo = obtenerId(request);
           objper.setId(idNuevo);
           lista.add(objper);
           
       }
       else{
           int pos = buscarPorIndice(request, id);
           lista.set(pos, objper);
           
           
       }
       request.setAttribute("listaper", lista);
       response.sendRedirect("index.jsp");
       
    }
    public int buscarPorIndice(HttpServletRequest request, int id){
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listaper");
        
        int pos = -1;
        if (lista != null){
            for (Estudiante ele : lista){
                ++pos;
                if(ele.getId()== id){
                    break;
                }
            }
        }
        return pos;
    }
public int obtenerId(HttpServletRequest request){
    HttpSession ses = request.getSession();
    ArrayList<Estudiante> lista = (ArrayList<Estudiante>)ses.getAttribute("listaper");
    int idn = 0;
    for (Estudiante ele : lista){
      idn =ele.getId();
      
    }
    return idn + 1;
}
}
