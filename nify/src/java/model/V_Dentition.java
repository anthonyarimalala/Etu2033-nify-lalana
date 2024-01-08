package model;

import database.Connex;
import generalise.Column;
import generalise.CrudOperation;
import generalise.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Table(name="v_dentition")
public class V_Dentition {
    
    @Column(name="id_dentition")
    int idDentition;
    @Column(name="id_personne")
    int idPersonne;
    @Column(name="nom")
    String nom;
    @Column(name="prenom")
    String prenom;
    @Column(name="id_dent")
    int idDent;
    @Column(name="id_etat")
    int idEtat;
    @Column(name="etat")
    String etat;
    @Column(name="couleur")
    String couleur;
    @Column(name="traitement")
    double traitement;
    @Column(name="enlevement")
    double enlevement;
    @Column(name="remplacement")
    double remplacement;
    @Column(name="nettoyage")
    double nettoyage;
    @Column(name="prior_beaute")
    int priorBeaute;
    @Column(name="prior_sante")
    int priorSante;
    
    double total;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        List<V_Dentition> dentitions = selectFromBeaute(1, 1000000);
        
        for(V_Dentition v: dentitions){
            System.out.println(v.toString());
        }
    }
    
    public static List<V_Dentition> selectFromBeaute(int idPersonne, double argent) throws ClassNotFoundException, SQLException {
        Connection connection = Connex.getConnection();
        //String query = "SELECT * FROM v_dentition WHERE id_personne=? AND id_etat!=10 AND ((traitement<=? AND id_etat != 0) OR remplacement <= ?) ORDER BY prior_beaute DESC";
        String query = "SELECT * FROM v_dentition WHERE id_personne=? AND id_etat!=10 AND (enlevement<=? OR traitement<=? OR nettoyage<=?) ORDER BY prior_beaute DESC";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idPersonne);
            preparedStatement.setDouble(2, argent);
            preparedStatement.setDouble(3, argent);
            preparedStatement.setDouble(4, argent);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<V_Dentition> result = new ArrayList<>();

                while (resultSet.next()) {
                    V_Dentition vDentition = mapFromResultSet(resultSet);
                    result.add(vDentition);
                }

                return result;
            }
        }
    }
    
    public static List<V_Dentition> selectFromSante(int idPersonne, double argent) throws ClassNotFoundException, SQLException {
        Connection connection = Connex.getConnection();
        //String query = "SELECT * FROM v_dentition WHERE id_personne=? AND id_etat!=10 AND ((traitement<=? AND id_etat != 0) OR remplacement <= ?) ORDER BY prior_sante DESC";
        String query = "SELECT * FROM v_dentition WHERE id_personne=? AND id_etat!=10 AND (enlevement<=? OR traitement<=? OR nettoyage<=?) ORDER BY prior_sante DESC";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idPersonne);
            preparedStatement.setDouble(2, argent);
            preparedStatement.setDouble(3, argent);
            preparedStatement.setDouble(4, argent);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<V_Dentition> result = new ArrayList<>();

                while (resultSet.next()) {
                    V_Dentition vDentition = mapFromResultSet(resultSet);

                    result.add(vDentition);
                }

                return result;
            }
        }
    }
    
    public static V_Dentition mapFromResultSet(ResultSet resultSet) throws SQLException{
        
        double traitement = resultSet.getDouble("traitement");
        double enlevement = resultSet.getDouble("enlevement");
        double remplacement = resultSet.getDouble("remplacement");
        double nettoyage = resultSet.getDouble("nettoyage");
        int idEtat = resultSet.getInt("id_etat");
        
        double traitementTotal = getTraitementTotal(traitement, nettoyage, idEtat);
        double remplacementTotal = getRemplacementTotal(remplacement, enlevement, idEtat);
        double nettoyageTotal = getNettoyageTotal(nettoyage, idEtat);
        
       
        
        V_Dentition vDentition = new V_Dentition();
        vDentition.setIdDentition(resultSet.getInt("id_dentition"));
        vDentition.setIdPersonne(resultSet.getInt("id_personne"));
        vDentition.setNom(resultSet.getString("nom"));
        vDentition.setPrenom(resultSet.getString("prenom"));
        vDentition.setIdDent(resultSet.getInt("id_dent"));
        vDentition.setIdEtat(resultSet.getInt("id_etat"));
        vDentition.setEtat(resultSet.getString("etat"));
        vDentition.setCouleur(resultSet.getString("couleur"));
        vDentition.setTraitement(traitementTotal);
        vDentition.setEnlevement(enlevement);
        vDentition.setRemplacement(remplacementTotal);
        vDentition.setNettoyage(nettoyageTotal);
        vDentition.setPriorBeaute(resultSet.getInt("prior_beaute"));
        vDentition.setPriorSante(resultSet.getInt("prior_sante"));
        
        
        vDentition.setTotal(traitementTotal + remplacementTotal + nettoyageTotal);
        
        return vDentition;
    }
    
    
    public static double getRemplacementTotal(double remplacement, double enlevement, int idEtat){
        if(idEtat == 0) return remplacement;
        else if(1<=idEtat && idEtat<=3) return remplacement + enlevement;
                
        return 0;
    }
    
    public static double getTraitementTotal(double traitement, double nettoyage, int idEtat){
        if(4<=idEtat && idEtat<=7){
            double total = 0;
            for(int i=idEtat; i<=7 ; i++){
                total += traitement;
            }
            for(int i=8; i<=9 ; i++){
                total += nettoyage;
            }
            
            return total;
        }
        return 0;
    }
    
    public static double getNettoyageTotal(double nettoyage, int idEtat){
        if(8<=idEtat && idEtat<=9){
            double total = 0;
            for(int i=idEtat; i<=9; i++){
                total += nettoyage;
            }
            return total;
        }
        return 0;
    }
    
    public static double getTotal(double enlevement, double remplacement, double traitement, double nettoyage, int idEtat){
        if(idEtat==0){
            return remplacement; 
        }
        else if(idEtat<=1 && idEtat<=3){
            return remplacement + enlevement;
        }else if(idEtat<=4 && idEtat <=7){
            double trait = 0;
            for(int i=4; i<=7; i++){
                trait += traitement;
            }
            return trait;
        }else if(idEtat<=8 && idEtat <=9){
            double nett = 0;
            for(int i=4; i<=7; i++){
                nett += nettoyage;
            }
            return nett;
        }
        return 0;
    }
    
    

    public V_Dentition() {
    }

    public int getIdDentition() {
        return idDentition;
    }

    public void setIdDentition(int idDentition) {
        this.idDentition = idDentition;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getIdDent() {
        return idDent;
    }

    public void setIdDent(int idDent) {
        this.idDent = idDent;
    }

    public int getIdEtat() {
        return idEtat;
    }

    public void setIdEtat(int idEtat) {
        this.idEtat = idEtat;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public double getTraitement() {
        return traitement;
    }

    public void setTraitement(double traitement) {
        this.traitement = traitement;
    }


    public double getRemplacement() {
        return remplacement;
    }

    public void setRemplacement(double remplacement) {
        this.remplacement = remplacement;
    }

    public int getPriorBeaute() {
        return priorBeaute;
    }

    public void setPriorBeaute(int priorBeaute) {
        this.priorBeaute = priorBeaute;
    }

    public int getPriorSante() {
        return priorSante;
    }

    public void setPriorSante(int priorSante) {
        this.priorSante = priorSante;
    }

    public double getNettoyage() {
        return nettoyage;
    }

    public void setNettoyage(double nettoyage) {
        this.nettoyage = nettoyage;
    }

    public double getEnlevement() {
        return enlevement;
    }

    public void setEnlevement(double enlevement) {
        this.enlevement = enlevement;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "V_Dentition{" + "idDentition=" + idDentition + ", idPersonne=" + idPersonne + ", nom=" + nom + ", prenom=" + prenom + ", idDent=" + idDent + ", idEtat=" + idEtat + ", etat=" + etat + ", couleur=" + couleur + ", traitement=" + traitement + ", enlevement=" + enlevement + ", remplacement=" + remplacement + ", nettoyage=" + nettoyage + ", priorBeaute=" + priorBeaute + ", priorSante=" + priorSante + ", total=" + total + '}';
    }

    
    
    
    
}
