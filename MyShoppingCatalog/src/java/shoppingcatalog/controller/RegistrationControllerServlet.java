/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcatalog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shoppingcatalog.dao.RegistrationDAO;
import shoppingcatalog.dto.UserDTO;

/**
 *
 * @author Sahaj23
 */
public class RegistrationControllerServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            
            
            RequestDispatcher rd = null;
            try {
                
            boolean userFound = RegistrationDAO.searchUser(username);
            System.out.println(username+" "+userFound);
            boolean result=false;
            
            if (!userFound) {
                
                String password = request.getParameter("password");
                UserDTO user = new UserDTO();
                
                user.setUsername(username);
                user.setPassword(password);
                user.setUsertype("CUSTOMER");
                if(password!=""){
                result = RegistrationDAO.registerUser(user);
                }
                
                
            } 
                request.setAttribute("result",result);
                request.setAttribute("userfound",userFound);
                System.out.println("inside userfound "+result+" "+userFound);
                rd = request.getRequestDispatcher("registrationresponse.jsp");
        } catch (Exception ex) {
            request.setAttribute("ex", ex);
            rd = request.getRequestDispatcher("showexception.jsp");
            

        } finally {
            rd.forward(request, response);
        }
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
