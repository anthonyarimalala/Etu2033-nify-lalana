package model;

import database.Connex;
import generalise.Column;
import generalise.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Table(name="v_pk_rn")
public class VPkRn {
    
    @Column(name="id_pk_rn")
    int idPkRn;
    @Column(name="designation")
    String designation;
    @Column(name="rn")
    String rn;
    @Column(name="pk")
    int pk;
    @Column(name="etat")
    int etat;
    @Column(name="priorite")
    int priorite;
    @Column(name="enlevement")
    double enlevement;
    @Column(name="remplacement")
    double remplacement;
    @Column(name="traitement")
    double traitement;
    @Column(name="nettoyage")
    double nettoyage;
    
    double total;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        List<VPkRn> pkRns = selectFromSante("Rn2", 1200000);
        //System.out.println(pkRns.size());
        
        for(int i=0; i<pkRns.size() ; i++){
            System.out.println(pkRns.get(i).toString());
        }
        
    }
 
    public static List<VPkRn> selectFromBeaute(String rn, double argent) throws ClassNotFoundException, SQLException {
        Connection connection = Connex.getConnection();
        //String query = "SELECT * FROM v_pk_rn WHERE rn=? AND etat!=10 AND ((traitement<=? AND etat != 0) OR remplacement <= ?) ORDER BY priorite ASC";
        String query = "SELECT * FROM v_pk_rn WHERE rn=? AND etat!=10 AND (enlevement<=? OR traitement<=? OR nettoyage<=?) ORDER BY priorite ASC";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, rn);
            preparedStatement.setDouble(2, argent);
            preparedStatement.setDouble(3, argent);
            preparedStatement.setDouble(4, argent);
            
            System.out.println(preparedStatement.toString());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<VPkRn> result = new ArrayList<>();

                while (resultSet.next()) {
                    VPkRn vDentition = mapFromResultSet(resultSet);
                    result.add(vDentition);
                }
                connection.close();
                return result;
            }
        }
    }
    
    public static List<VPkRn> selectFromSante(String rn, double argent) throws ClassNotFoundException, SQLException {
        Connection connection = Connex.getConnection();
        //String query = "SELECT * FROM v_pk_rn WHERE rn=? AND etat!=10 AND ((traitement<=? AND etat != 0) OR remplacement <= ?) ORDER BY priorite DESC";
        String query = "SELECT * FROM v_pk_rn WHERE rn=? AND etat!=10 AND (enlevement<=? OR traitement<=? OR nettoyage<=?) ORDER BY priorite DESC";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, rn);
            preparedStatement.setDouble(2, argent);
            preparedStatement.setDouble(3, argent);
            preparedStatement.setDouble(4, argent);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<VPkRn> result = new ArrayList<>();

                while (resultSet.next()) {
                    VPkRn vDentition = mapFromResultSet(resultSet);

                    result.add(vDentition);
                }
                connection.close();
                return result;
            }
        }
    }
    
    public static VPkRn mapFromResultSet(ResultSet resultSet) throws SQLException{
        
        double traitement = resultSet.getDouble("traitement");
        double enlevement = resultSet.getDouble("enlevement");
        double remplacement = resultSet.getDouble("remplacement");
        double nettoyage = resultSet.getDouble("nettoyage");
        int idEtat = resultSet.getInt("etat");
        
        double remplacementTotal = getRemplacementTotal(remplacement, enlevement, idEtat);
        double traitementTotal = getTraitementTotal(traitement, nettoyage, idEtat);
        double nettoyageTotal = getNettoyageTotal(nettoyage, idEtat);
        
       
        
        VPkRn vPkRn = new VPkRn();
        vPkRn.setIdPkRn(resultSet.getInt("id_pk_rn"));
        vPkRn.setDesignation(resultSet.getString("designation"));
        vPkRn.setRn(resultSet.getString("rn"));
        vPkRn.setPk(resultSet.getInt("pk"));
        vPkRn.setEtat(resultSet.getInt("etat"));
        vPkRn.setPriorite(resultSet.getInt("priorite"));
        vPkRn.setEnlevement(enlevement);
        vPkRn.setRemplacement(remplacementTotal);
        vPkRn.setTraitement(traitementTotal);
        vPkRn.setNettoyage(nettoyageTotal);
                
               
        
        
        vPkRn.setTotal(traitementTotal + remplacementTotal + nettoyageTotal);
        
        return vPkRn;
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
    

    public VPkRn() {
    }

    public int getIdPkRn() {
        return idPkRn;
    }

    public void setIdPkRn(int idPkRn) {
        this.idPkRn = idPkRn;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getRn() {
        return rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public double getEnlevement() {
        return enlevement;
    }

    public void setEnlevement(double enlevement) {
        this.enlevement = enlevement;
    }

    public double getRemplacement() {
        return remplacement;
    }

    public void setRemplacement(double remplacement) {
        this.remplacement = remplacement;
    }

    public double getTraitement() {
        return traitement;
    }

    public void setTraitement(double traitement) {
        this.traitement = traitement;
    }

    public double getNettoyage() {
        return nettoyage;
    }

    public void setNettoyage(double nettoyage) {
        this.nettoyage = nettoyage;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "VPkRn{" + "idPkRn=" + idPkRn + ", designation=" + designation + ", rn=" + rn + ", pk=" + pk + ", priorite=" +priorite + ", etat=" + etat +", enlevement=" + enlevement + ", remplacement=" + remplacement + ", traitement=" + traitement + ", nettoyage=" + nettoyage + ", total=" + total + '}';
    }
    
    
    
    
    
}
