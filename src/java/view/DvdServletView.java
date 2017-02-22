/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.services.Database;
import model.DvdItem;
/**
 *
 * @author micky
 */
@WebServlet(name = "DvdServletView", urlPatterns = {"/DvdServletView"})
public class DvdServletView extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<DvdItem> dvd4ever = new ArrayList<>();
        dvd4ever= (ArrayList)request.getAttribute("Libreria");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DvdServletView</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Libreria: " +  dvd4ever.size() + "</h3>");
            out.println("<ul>");
            for(int i=0;i<dvd4ever.size(); i++){
                out.println("<table>");
                out.println("<tr><td><b>Titolo</td></b><td><b>Genere</td></b><td><b>Anno</td></b></tr>");
                out.println("<tr><td>" +dvd4ever.get(i).getDvdTitolo()+"</td>"); 
                out.println ("<td>"+dvd4ever.get(i).getDvdGenere()+"</td>");
                out.println ("<td>"+dvd4ever.get(i).getDvdYear()+"</tr></td>"); 
                out.println ("</table>");
            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
