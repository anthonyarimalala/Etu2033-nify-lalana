/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dentition;

/**
 *
 * @author PC
 */
public class PointPointServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PointPointServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PointPointServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            try{
                
                int idPersonne = Integer.parseInt(request.getParameter("idPersonne")) ;
                String type = request.getParameter("type");
                String etat = request.getParameter("etat");
                out.println(type);
                
                if(type.contains(";")){
                    String[] split = type.split(";");
                    String[] splitValue = etat.split(";");
                   
                    for(int i=0; i<split.length; i++){
                        if(1<=Integer.parseInt(split[i]) && Integer.parseInt(split[i])<=16){
                            if(0<=Integer.parseInt(splitValue[i]) && Integer.parseInt(splitValue[i])<= 10){
                                Dentition.updateDentition(idPersonne, Integer.parseInt(split[i]), Integer.parseInt(splitValue[i]));
                            }
                        }
                        if(21<=Integer.parseInt(split[i]) && Integer.parseInt(split[i])<=36){
                            if(0<=Integer.parseInt(splitValue[i]) && Integer.parseInt(splitValue[i])<= 10){
                                Dentition.updateDentition(idPersonne, Integer.parseInt(split[i]), Integer.parseInt(splitValue[i]));
                            }
                        }
                    }
                    
                    
                }else if(type.contains("-")){
                    String[] split = type.split("-");
                    out.println(split[0]+"   "+split[1]);
                    
                    int etatInt = Integer.parseInt(etat);
                    
                    Dentition.updateDentition(idPersonne, Integer.parseInt(split[0]), Integer.parseInt(split[1]), etatInt);
                    
                    
                }else{
                    Dentition.updateDentition(idPersonne, Integer.parseInt(type), Integer.parseInt(etat));
                }
                
                
//                RequestDispatcher dispatcher = request.getRequestDispatcher("accueil.jsp");
//                dispatcher.forward(request, response);
                
            }catch(Exception e){
                e.printStackTrace(out);
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
