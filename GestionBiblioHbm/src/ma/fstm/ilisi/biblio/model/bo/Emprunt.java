package ma.fstm.ilisi.biblio.model.bo;

public class Emprunt  implements java.io.Serializable {


     private EmpruntId id;
     private int  retourne;
    public Emprunt() {
    }

    public int getRetourne() {
        return retourne;
    }

    public void setRetourne(int retourne) {
        this.retourne = retourne;
    }

    public Emprunt(EmpruntId id) {
       this.id = id;
       this.retourne=0;
    }

    public Emprunt(EmpruntId id, int retourne) {
        this.id = id;
        this.retourne = retourne;
    }
   
    public EmpruntId getId() {
        return this.id;
    }
    
    public void setId(EmpruntId id) {
        this.id = id;
    }



}


