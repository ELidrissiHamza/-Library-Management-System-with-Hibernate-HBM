package ma.fstm.ilisi.biblio.model.bo;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Adherant  implements java.io.Serializable {


     private String cin;
     private String nom;
     private String prenom;
     private Set emprunts = new HashSet<>();

    public Adherant() {
    }

    public Adherant(String nom, String prenom,String cin) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin=cin;
    }

	
    public Adherant(String idad) {
        this.cin = idad;
    }
    public Adherant(String idad, String nom, String prenom, Set emprunts) {
       this.cin = idad;
       this.nom = nom;
       this.prenom = prenom;
       this.emprunts = emprunts;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
  
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Set getEmprunts() {
        return this.emprunts;
    }
    
    public void setEmprunts(Set emprunts) {
        this.emprunts = emprunts;
    }




}


