
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
import model.CoutRn;
import model.PkRn;
import model.Rn;

public class AjoutRnServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AjoutRnServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjoutRnServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
            try{
                Connection connection = Connex.getConnection();
                CrudOperation crud = new CrudOperation(connection);
                
                String rn = request.getParameter("rn");
                int nbPk = Integer.parseInt(request.getParameter("nbPk"));
                int moitie = nbPk/2;
                int priorite = 0;
                
                
                double enlevement = Double.parseDouble(request.getParameter("enlevement"));
                double remplacement = Double.parseDouble(request.getParameter("remplacement"));
                double traitement = Double.parseDouble(request.getParameter("traitement"));
                double nettoyage = Double.parseDouble(request.getParameter("nettoyage"));
                
                Rn rn_obj = new Rn(rn, nbPk);
                CoutRn cout = new CoutRn(rn, enlevement, remplacement, traitement, nettoyage);
                
                
                
                crud.save(rn_obj);
                crud.save(cout);
                
                for(int i=0; i<=nbPk; i++){
                    
                    PkRn pkRn = new PkRn(rn, i, priorite);
                    
                    crud.save(pkRn);
                    if(i<moitie) priorite += 1;
                    else if(i>moitie) priorite -= 1;
                }
                
                connection.close();
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
