/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "LoginController";
    private static final String SEARCH = "SearchController";
    private static final String LOGOUT = "LogoutController";
    private static final String DELETE = "DeleteController";
    private static final String UPDATE = "UpdateController";
    private static final String CREATE = "CreateControllers";
    private static final String ADD_TO_CART = "AddToCartController";
    private static final String VIEW_CART = "ViewCart.jsp";
    private static final String REMOVE_ITEM = "RemoveItemController";
     private static final String EDIT_ITEM = "EditItemController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try{
            String action = request.getParameter("action");
            if("Login".equals(action)){
                url = SUCCESS;
            }else if("Search".equals(action)){
                url = SEARCH;
            }else if("Logout".equals(action)){
                url = LOGOUT;
            }else if("Delete".equals(action)){
                url = DELETE;
            }else if("Update".equals(action)){
                url = UPDATE;
            }else if("Create".equals(action)){
                url = CREATE;
            }else if("Add".equals(action)){
                url = ADD_TO_CART;
            }else if("View".equals(action)){
                url = VIEW_CART;
            }else if("Remove".equals(action)){
                url = REMOVE_ITEM;
            }else if("Edit".equals(action)){
                url = EDIT_ITEM;
            }
        }catch(Exception event){
            log("Error at MainController: " + event.toString());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
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
