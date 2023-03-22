package ma.fstm.ilisi.biblio.model.bo;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Exemplaire  implements java.io.Serializable {


     private int idexp;
     private Livre livre;
     private Set emprunts = new HashSet<>();

    public Exemplaire() {
    }

    public Exemplaire(int idexp, Livre livre) {
        this.idexp = idexp;
        this.livre = livre;
    }

	
    public Exemplaire(int idexp) {
        this.idexp = idexp;
    }
    public Exemplaire(int idexp, Livre livre, Set emprunts) {
       this.idexp = idexp;
       this.livre = livre;
       this.emprunts = emprunts;
    }
   
    public int getIdexp() {
        return this.idexp;
    }
    
    public void setIdexp(int idexp) {
        this.idexp = idexp;
    }
    public Livre getLivre() {
        return this.livre;
    }
    
    public void setLivre(Livre livre) {
        this.livre = livre;
    }
    public Set getEmprunts() {
        return this.emprunts;
    }
    
    public void setEmprunts(Set emprunts) {
        this.emprunts = emprunts;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.idexp;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Exemplaire other = (Exemplaire) obj;
        if (this.idexp != other.idexp) {
            return false;
        }
        return true;
    }

  



}


