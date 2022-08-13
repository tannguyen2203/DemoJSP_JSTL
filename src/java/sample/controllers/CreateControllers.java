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
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserError;

/**
 *
 * @author ADMIN
 */
public class CreateControllers extends HttpServlet {

    private static final String ERROR = "createUser.jsp";
    private static final String SUCCESS = "login.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            // check validation: check ID, name, role, pass
            boolean check = true;
            UserError userError = new UserError();
            if(userID.length()<2 || userID.length()>10)
            {
                userError.setUserID("UserID must be in [2,10]");
                check=false;
            }
            if(fullName.length()<2 || fullName.length()>10)
            {
                userError.setFullName("fullName must be in [2,10]");
                check=false;
            }
            if(roleID.isEmpty()){
                userError.setRoleID("please select your role");
            }
            
            if(password.length()<1 || password.length()>50)
            {
                userError.setPassword("Password must be in [1,50]");
                check=false;
            }
            if(!confirm.equals(password))
            {
                userError.setConfirm("hai password khong giong nhau");
                check=false;
            }
            //kiem tra userID
            UserDAO dao = new UserDAO();
            UserDTO checkUser = dao.getUserInfor(userID);
            if(checkUser != null){
                userError.setUserID("Duplicate userID !");
                check = false;
            }
            if(check){
                boolean checkInsert = dao.insert(new UserDTO(userID, fullName, roleID, password));
                if(checkInsert){
                    url = SUCCESS;
                }
            }else{
                request.setAttribute("ERROR_USER", userError);
            }
        }catch(Exception event){
            log("Error at CreateController: " + event.toString());
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
