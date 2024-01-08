/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dentition;

/**
 *
 * @author PC
 */
public class ManambotraServlet extends HttpServlet {

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
            out.println("<title>Servlet ManambotraServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManambotraServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
            try{
                int idPersonne = Integer.parseInt(request.getParameter("idPersonne"));
                String choixDents = request.getParameter("choixDents");
                int[] choix = this.convertirChaineEnTableau(choixDents);



                out.println(choixDents);
                for(int i=0; i<choix.length; i++){
                     out.println(Dentition.updateDentitionReparation(idPersonne, choix[i]));
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
    private int[] convertirChaineEnTableau(String chaine) {
        // Séparer la chaîne en utilisant la virgule comme délimiteur
        String[] valeurs = chaine.split(",");

        // Convertir les valeurs en tableau d'entiers
        int[] tableau = Arrays.stream(valeurs)
                .mapToInt(Integer::parseInt)
                .toArray();

        // Supprimer les doublons en utilisant un ensemble (Set)
        Set<Integer> ensembleSansDoublons = new HashSet<>(Arrays.stream(tableau).boxed().collect(Collectors.toList()));

        // Convertir l'ensemble en tableau d'entiers
        int[] tableauSansDoublons = ensembleSansDoublons.stream().mapToInt(Integer::intValue).toArray();

        return tableauSansDoublons;
    }
}
