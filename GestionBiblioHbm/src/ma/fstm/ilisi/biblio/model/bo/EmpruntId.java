package ma.fstm.ilisi.biblio.model.bo;


import java.util.Objects;


public class EmpruntId  implements java.io.Serializable {


     private Exemplaire exmp;
     private Adherant ad;
     private String dateemp;

    public EmpruntId() {
    }

    public EmpruntId(Exemplaire exmp, Adherant ad, String dateemp) {
       this.exmp = exmp;
       this.ad = ad;
       this.dateemp = dateemp;
    }

    public Exemplaire getExmp() {
        return exmp;
    }

    public void setExmp(Exemplaire exmp) {
        this.exmp = exmp;
    }

    public Adherant getAd() {
        return ad;
    }

    public void setAd(Adherant ad) {
        this.ad = ad;
    }

    public String getDateemp() {
        return dateemp;
    }

    public void setDateemp(String dateemp) {
        this.dateemp = dateemp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.exmp);
        hash = 47 * hash + Objects.hashCode(this.ad);
        hash = 47 * hash + Objects.hashCode(this.dateemp);
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
        final EmpruntId other = (EmpruntId) obj;
        if (!Objects.equals(this.exmp, other.exmp)) {
            return false;
        }
        if (!Objects.equals(this.ad, other.ad)) {
            return false;
        }
        if (!Objects.equals(this.dateemp, other.dateemp)) {
            return false;
        }
        return true;
    }

   
  
   
   


}


