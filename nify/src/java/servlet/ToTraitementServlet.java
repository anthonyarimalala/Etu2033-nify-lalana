
package servlet;

import database.Connex;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.V_Dentition;

public class ToTraitementServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ToTraitementServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ToTraitementServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            try{
                Connection connection = Connex.getConnection();
                
                String option = request.getParameter("option");
                String argentString = request.getParameter("argent");
                double argent = Double.parseDouble(argentString);
                String idPersonneString = request.getParameter("idPersonne");
                int idPersonne = Integer.parseInt(idPersonneString);
                
                List<V_Dentition> dentitions = new ArrayList<>();
                
                if(option.equals("sante")){
                    dentitions = V_Dentition.selectFromSante(idPersonne, argent);
                }
                if(option.equals("beaute")){
                    dentitions = V_Dentition.selectFromBeaute(idPersonne, argent);
                }
                
                List<V_Dentition> dentitionsSend = new ArrayList<>();
                double prixTotal = 0;
                double reste = argent;
                for(V_Dentition den: dentitions){
                    double prixTotalTemp = prixTotal + den.getTotal();
                    if(prixTotalTemp<=argent){
                        prixTotal += den.getTotal();
                        dentitionsSend.add(den);
                        reste -= den.getTotal();
                        
                    }
                }
                request.setAttribute("total", prixTotal);
                request.setAttribute("reste", reste);
                request.setAttribute("argent", argent);
                request.setAttribute("dentitions", dentitionsSend);
                request.setAttribute("dentitionsChoix", dentitions);
                request.setAttribute("option", option);
                request.setAttribute("idPersonne", idPersonne);
                
                
                connection.close();
                RequestDispatcher dispatcher = request.getRequestDispatcher("traitement.jsp");
                dispatcher.forward(request, response);
                
                
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
