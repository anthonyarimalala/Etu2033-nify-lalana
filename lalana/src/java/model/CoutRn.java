
package model;

import database.Connex;
import generalise.Column;
import generalise.CrudOperation;
import generalise.Table;
import java.sql.Connection;
import java.sql.SQLException;

@Table(name="cout_rn")
public class CoutRn {
    
    @Column(name="id_cout", autoIncrement = true, id = true)
    int idCout;
    
    @Column(name="rn")
    String rn;
    
    @Column(name="enlevement")
    double enlevement;
    
    @Column(name="remplacement")
    double remplacement;
    
    @Column(name="traitement")
    double traitement;
    
    @Column(name="nettoyage")
    double nettoyage;
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Connection connection = Connex.getConnection();
        CrudOperation crud = new CrudOperation(connection);
        
        crud.selectAll(CoutRn.class);
        
        connection.close();
    }

    public CoutRn(String rn, double enlevement, double remplacement, double traitement, double nettoyage) {
        this.rn = rn;
        this.enlevement = enlevement;
        this.remplacement = remplacement;
        this.traitement = traitement;
        this.nettoyage = nettoyage;
    }

    
    public CoutRn() {
    }

    public int getIdCout() {
        return idCout;
    }

    public void setIdCout(int idCout) {
        this.idCout = idCout;
    }

    public String getRn() {
        return rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
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
    
    
    
    
    
}
