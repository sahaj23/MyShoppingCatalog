/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcatalog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import shoppingcatalog.dao.RegistrationDAO;
import shoppingcatalog.dao.StoreDAO;
import shoppingcatalog.dto.ItemDTO;
import shoppingcatalog.dto.ItemInfoDTO;

public class StoreControllerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sess = request.getSession();
            String username = (String) sess.getAttribute("username");
            RequestDispatcher rd = null;

            try {
                if (username == null) {
                    sess.invalidate();
                    rd = request.getRequestDispatcher("accessdenied.html");
                } 
                else {
                    String itemId = request.getParameter("itemId");
                    String itemType = request.getParameter("itemType");
                    String needId=request.getParameter("needId");
                    String productName=request.getParameter("pName");
                    String details=request.getParameter("details");
                    String delete=request.getParameter("delete");
                    String update=request.getParameter("update");
                    String needUserId=request.getParameter("needUserId");
                    String userName=request.getParameter("userName");
                    String remove=request.getParameter("remove");
                   System.out.println(productName+" lol");
                    if(remove!=null){
                     if(RegistrationDAO.removeUser(userName)){
                      rd=request.getRequestDispatcher("userremovedsuccessfully.jsp");
                     }
                     else rd=request.getRequestDispatcher("showexception.jsp");
                    }
                    else if(needUserId!=null){
                     ArrayList<String> uid=RegistrationDAO.getUserId();
                     request.setAttribute("uid",uid);
                     rd=request.getRequestDispatcher("getuserids.jsp");
                    }
                    else if(update!=null && itemId!=null){
                     ItemDTO item=new ItemDTO();
                    // System.out.println(item+" hehre is");
                     item.setItemId(Integer.parseInt(itemId));
                     item.setItemType(request.getParameter("pType"));
                     item.setItemName(request.getParameter("pName"));
                     item.setItemDesc(request.getParameter("pDesc"));
                     item.setItemImage(request.getParameter("pImage"));
                     item.setItemPrice(Double.parseDouble(request.getParameter("pPrice")));
                     System.out.println(item);
                   //  System.out.println(item.getItemType()+" "+item.getItemName()+" "+item.getItemDesc());
                     if(StoreDAO.updateItem(item)>0) rd = request.getRequestDispatcher("updatedsuccessfully.jsp");
                     else rd = request.getRequestDispatcher("showexception.jsp");
                    }
                    else if(delete!=null && itemId!=null){
                        int del=StoreDAO.deleteItem(Integer.parseInt(itemId));
                        if(del>0)rd = request.getRequestDispatcher("deletedsuccessfully.jsp");
                        else rd = request.getRequestDispatcher("showexception.jsp");
                    }
                    else if(details!=null && itemId!=null){
                     ItemDTO item=StoreDAO.getItemDetails(Integer.parseInt(itemId));
                     request.setAttribute("details",item);
                     rd = request.getRequestDispatcher("formdetails.jsp");
                    }
                    else if(productName!=null){
                        
                     String productType=request.getParameter("pType");;
                     double productPrice=Double.parseDouble(request.getParameter("pPrice"));;
                     String productDesc=request.getParameter("pDesc");;
                     String productImage=request.getParameter("pImage");;  
                     StoreDAO.addItem(productName,productType,productPrice,productDesc, productImage);
                     rd=request.getRequestDispatcher("adminhomepage.jsp");
                    }
                    else if(needId!=null){
                     ArrayList<Integer> ids=(ArrayList<Integer>) StoreDAO.getId();
                     request.setAttribute("ids",ids);
                     for(int id:ids) System.out.println(id);
                     rd=request.getRequestDispatcher("showids.jsp");
                    }
                   // System.out.println("Itemtype:"+itemType);
                    else if (itemId == null && itemType == null) {
                        ArrayList<String> itemTypes = (ArrayList<String>) StoreDAO.getItemTypes();
                        
                        request.setAttribute("itemTypes", itemTypes);
                        rd = request.getRequestDispatcher("seestore.jsp");
                    }
                    else if(itemId==null && itemType!=null){
                    ArrayList<ItemInfoDTO> items=(ArrayList<ItemInfoDTO>) StoreDAO.getItemsByType(itemType);
                    request.setAttribute("items", items);
                    request.setAttribute("itemType",itemType);
                        rd = request.getRequestDispatcher("showitemsbytype.jsp");
                    }
                    else{
                     ItemDTO item=StoreDAO.getItemDetails(Integer.parseInt(itemId));
                     request.setAttribute("details",item);
                     rd = request.getRequestDispatcher("showitemdetails.jsp");
                    }
                }
            } catch (Exception ex) {
                System.out.println("Exception occured " + ex);
                ex.printStackTrace();
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
