package ma.fstm.ilisi.biblio.model.bo;

import java.util.HashSet;
import java.util.Set;

public class Livre  implements java.io.Serializable {


     private String isbn;
     private String titre;
     private Set exemplaires = new HashSet<>();

    public Livre() {
    }
    public Livre(String isbn,String titre) {
        this.isbn=isbn;
        this.titre=titre;
    }

	
    public Livre(String isbn) {
        this.isbn = isbn;
    }
    public Livre(String isbn, String titre, Set exemplaires) {
       this.isbn = isbn;
       this.titre = titre;
       this.exemplaires = exemplaires;
    }
   
    public String getIsbn() {
        return this.isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitre() {
        return this.titre;
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public Set getExemplaires() {
        return this.exemplaires;
    }
    
    public void setExemplaires(Set exemplaires) {
        this.exemplaires = exemplaires;
    }




}


