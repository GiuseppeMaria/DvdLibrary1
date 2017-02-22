/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.services.Database;
/**
 *
 * @author micky
 */
@WebServlet(name = "AddDvd", urlPatterns = {"/AddDvd"})
public class AddDvd extends HttpServlet {

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
         List errorMsgs = new LinkedList();
        request.setAttribute("errorMsgs", errorMsgs);
        try{
            String titolo=request.getParameter("filmInserito").trim();
            String genere=request.getParameter("Generi").trim();
            String anno=request.getParameter("annoInserito").trim();
            int annoint=0;
           
            try{
                annoint=Integer.parseInt(anno);
                if ((annoint==0)||(annoint>2018)){
                errorMsgs.add("L'anno dev'essere maggiore di zero e minore di 2018");}
                if (genere.equals("UNKNOWN")){
                    errorMsgs.add("Devi inserire un genere!");}
                if (titolo.length()==0){
                    errorMsgs.add("Devi inserire un titolo!!");}
                if (! errorMsgs.isEmpty()){
                    RequestDispatcher view = request.getRequestDispatcher("ErrorView");
                    view.forward(request, response);
                    return;
                }
                Database.getInstance().addObjectToArrayList(titolo, genere, annoint);
                RequestDispatcher view = request.getRequestDispatcher("SuccessView");
                view.forward(request, response);
                return;
            }catch(NumberFormatException e){
                errorMsgs.add("l'anno deve essere un intero positivo "+e.getMessage());
            }
        }catch(IOException | ServletException e){
            errorMsgs.add(e.getMessage());
            RequestDispatcher view = request.getRequestDispatcher("ErrorView");
            view.forward(request, response);
            return;
        }
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
        //processRequest(request, response);
        List errorMsgs = new LinkedList();
        request.setAttribute("errorMsgs", errorMsgs);
        try{
            String titolo=request.getParameter("filmInserito").trim();
            String genere=request.getParameter("Generi").trim();
            String anno=request.getParameter("annoInserito").trim();
            int annoint=0;
           
            try{
                annoint=Integer.parseInt(anno);
                if ((annoint==0)||(annoint>2018)){
                errorMsgs.add("L'anno dev'essere maggiore di zero e minore di 2018");}
                if (genere.equals("UNKNOWN")){
                    errorMsgs.add("Devi inserire un genere!");}
                if (titolo.length()==0){
                    errorMsgs.add("Devi inserire un titolo!!");}
                if (! errorMsgs.isEmpty()){
                    RequestDispatcher view = request.getRequestDispatcher("ErrorView");
                    view.forward(request, response);
                    return;
                }  
                Database.getInstance().addObjectToArrayList(titolo, genere, annoint);
                RequestDispatcher view = request.getRequestDispatcher("/SuccessView");
                view.forward(request, response);
                return;
            }catch(NumberFormatException e){
                errorMsgs.add("l'anno deve essere un intero positivo "+e.getMessage());
            }
        }catch(IOException | ServletException e){
            errorMsgs.add(e.getMessage());
            RequestDispatcher view = request.getRequestDispatcher("ErrorView");
            view.forward(request, response);  
        }
        //DvdCollection.getInstance().addObjectToArrayList(titolo, genere, annoint);
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
