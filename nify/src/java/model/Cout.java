
package model;

import generalise.Column;
import generalise.Table;

@Table(name="cout")
public class Cout {
    @Column(name="id_cout", autoIncrement = true, id = true)
    int idCout;
    
    @Column(name="num_dent")
    int numDent;
    
    @Column(name="traitement")
    double traitement;
    
    @Column(name="prior_traitement")
    int priorTraitement;
    
    @Column(name="remplacement")
    double remplacement;
    
    @Column(name="prior_remplacement")
    double priorRemplacement;

    public Cout() {
    }

    public int getIdCout() {
        return idCout;
    }

    public void setIdCout(int idCout) {
        this.idCout = idCout;
    }

    public int getNumDent() {
        return numDent;
    }

    public void setNumDent(int numDent) {
        this.numDent = numDent;
    }

    public double getTraitement() {
        return traitement;
    }

    public void setTraitement(double traitement) {
        this.traitement = traitement;
    }

    public int getPriorTraitement() {
        return priorTraitement;
    }

    public void setPriorTraitement(int priorTraitement) {
        this.priorTraitement = priorTraitement;
    }

    public double getRemplacement() {
        return remplacement;
    }

    public void setRemplacement(double remplacement) {
        this.remplacement = remplacement;
    }

    public double getPriorRemplacement() {
        return priorRemplacement;
    }

    public void setPriorRemplacement(double priorRemplacement) {
        this.priorRemplacement = priorRemplacement;
    }
    
    
    

}
