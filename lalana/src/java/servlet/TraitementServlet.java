/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import database.Connex;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PkRn;
import model.VPkRn;

/**
 *
 * @author PC
 */
public class TraitementServlet extends HttpServlet {

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
            out.println("<title>Servlet TraitementServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TraitementServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
            try{
                Connection connection = Connex.getConnection();
                double argent = Double.parseDouble(request.getParameter("argent"));
                String rn = request.getParameter("rn");
                String option = request.getParameter("option");
                
                List<VPkRn> pkRns = new ArrayList<>();
                
                if(option.equals("sante")){
                    out.print("<br/>");
                    out.println("sante<br/>");
                    out.println("Rn: "+rn+"<br/>");
                    out.println("Argent: "+argent+"<br/>");
                    pkRns = VPkRn.selectFromSante(rn, argent);
                }
                if(option.equals("beaute")){
                    out.print("<br/>");
                    out.println("beaute<br/>");
                    out.println("Rn: "+rn+"<br/>");
                    out.println("Argent: "+argent+"<br/>");
                    pkRns = VPkRn.selectFromBeaute(rn, argent);
                }
                
                out.print("<br/>");
                out.print("pkRn: "+pkRns.size());
                
                List<VPkRn> pkRnSend = new ArrayList<>();
                double prixTotal = 0;
                double reste = argent;
                
                for(VPkRn vp : pkRns){
                    double prixTotalTemp = prixTotal + vp.getTotal();
                    if(prixTotalTemp<=argent){
                        prixTotal += vp.getTotal();
                        PkRn.updateDentitionReparation(rn, vp.getPk());
                        reste -= vp.getTotal();
                        
                    }
                }
                
                response.sendRedirect("RootServlet");
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
