/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcatalog.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import shoppingcatalog.dao.StoreDAO;
import shoppingcatalog.dto.ItemDTO;

/**
 *
 * @author Sahaj23
 */
public class UpdateProductControllerServlet extends HttpServlet {

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
        RequestDispatcher rd = null;
        try {
            ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
            List<FileItem> multiparts = sfu.parseRequest(new ServletRequestContext(request));
            ArrayList<String> objValues = new ArrayList<>();
            for (FileItem item : multiparts) {

                if (item.isFormField()) {

                    String fieldName = item.getFieldName();
                    String fieldValue = item.getString();
                    //System.out.println(fieldName+":"+fieldValue);
                    objValues.add(fieldValue);

                } else {

                    String fieldName = item.getFieldName();
                    //String fileName = new File(item.getName()).getName();
                    String fileName = item.getName();
                    objValues.add(fileName);
                    System.out.println(fieldName + ":" + fileName);
                    InputStream fileContent = item.getInputStream();
                    System.out.println("content:" + fileContent);

                    String imagePath = "C:\\Users\\Sahaj23\\Documents\\NetBeansProjects\\MyShoppingCatalog\\web\\images";
                    // System.out.println("path is:"+imagePath);
                    File myFile = new File(imagePath + "/" + fileName);
                    //System.out.println("File will be saved at:"+myFile.getAbsolutePath());
                    //   System.out.println("File created:"+myFile.createNewFile());
                    item.write(myFile);
                    // System.out.println("File saved at:"+myFile.getAbsolutePath());

                }

            }
            for (String s : objValues) {
                System.out.println("lola " + s);
            }
            ItemDTO obj = new ItemDTO();
            obj.setItemImage(objValues.get(4));
            obj.setItemName(objValues.get(0));
            obj.setItemType(objValues.get(1));
            obj.setItemDesc(objValues.get(3));
            obj.setItemPrice(Double.parseDouble(objValues.get(2)));
            obj.setItemId(Integer.parseInt(objValues.get(9)));
            int result = StoreDAO.updateItem(obj);

            if (result == 1) {
                System.out.println("success.html");
                rd = request.getRequestDispatcher("success.html");
            } else {
                rd = request.getRequestDispatcher("failure.html");
            }
        } catch (Exception ex) {
            rd = request.getRequestDispatcher("showexception.jsp");
            request.setAttribute("ex", ex);
            System.out.println("Exception:" + ex);
            ex.printStackTrace();
        } finally {
            rd.forward(request, response);
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
