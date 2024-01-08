
package servlet;

import database.Connex;
import generalise.CrudOperation;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dentition;
import model.Personne;


public class InsertPersonneServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertPersonneServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertPersonneServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            try{
                
                Connection connection = Connex.getConnection();
                CrudOperation crud = new CrudOperation(connection);
                
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                Personne personne = new Personne(nom, prenom);
                
                String idString = crud.saveReturn(personne);
                int idPersonne = Integer.parseInt(idString);
                
                for(int i = 1; i<17; i++) {
                    String etatString = request.getParameter(String.valueOf(i));
                    int etat = Integer.parseInt(etatString);
                    Dentition dentition = new Dentition(idPersonne, i, etat);
                    crud.save(dentition);
                }
                for(int i = 21; i<37; i++) {
                    String etatString = request.getParameter(String.valueOf(i));
                    int etat = Integer.parseInt(etatString);
                    Dentition dentition = new Dentition(idPersonne, i, etat);
                    crud.save(dentition);
                }
                
                connection.close();
                response.sendRedirect("ToAjoutClientServlet");
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
