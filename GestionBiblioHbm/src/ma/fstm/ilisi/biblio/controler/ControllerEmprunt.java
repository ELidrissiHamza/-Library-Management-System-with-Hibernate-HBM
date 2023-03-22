/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.fstm.ilisi.biblio.controler;


import java.time.LocalDate;

import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import ma.fstm.ilisi.biblio.model.bo.Adherant;
import ma.fstm.ilisi.biblio.model.bo.Emprunt;
import ma.fstm.ilisi.biblio.model.bo.EmpruntId;
import ma.fstm.ilisi.biblio.model.bo.Exemplaire;
import ma.fstm.ilisi.biblio.model.bo.Livre;
import ma.fstm.ilisi.biblio.model.dao.DAOAdherant;
import ma.fstm.ilisi.biblio.model.dao.DAOEmprunt;
import ma.fstm.ilisi.biblio.model.dao.DAOExemplaire;
import ma.fstm.ilisi.biblio.model.dao.DAOLivre;

/**
 *
 * @author S USER
 */
public class ControllerEmprunt {
    
    public static void ajouterEmprunt(String cin, String isbn,JFrame f) {
        DAOEmprunt daoEM=new DAOEmprunt();
        DAOExemplaire daoE=new DAOExemplaire();
        DAOAdherant daoA=new DAOAdherant();
        DAOLivre daoL = new DAOLivre();
        Livre L=daoL.findByIsbn(isbn);
        Adherant ads=daoA.findByCin(cin);
        Exemplaire exp=daoE.getAvailableExp(isbn);

       boolean a= daoEM.create(new Emprunt(new EmpruntId(exp, ads,LocalDate.now().toString() )));

    }
    public static void retournerEmprunt(JTable emprunts,JFrame f) {
         String msg="Erreur!!!!! \nSelectionner un emprunt";
        if(emprunts.getSelectedRow()>=0){ 
            String cin=emprunts.getModel().getValueAt(emprunts.getSelectedRow(), 0).toString();
            int idex= Integer.parseInt(emprunts.getModel().getValueAt(emprunts.getSelectedRow(), 2).toString());
            String date=emprunts.getModel().getValueAt(emprunts.getSelectedRow(), 3).toString();

            DAOEmprunt daom=new DAOEmprunt();
            DAOAdherant daoA=new DAOAdherant();
            Exemplaire ex=new Exemplaire(idex);
            Adherant ads= daoA.findByCin(cin);
            if(ads==null) msg="Adherent n'existe pas";
            else if(ex==null) msg="Livre n'existe pas";
            else{
                EmpruntId idemp=new EmpruntId(ex,ads, date);
                msg=daom.delete(new Emprunt(idemp, 1))?"Emprunt retournee":"probleme !!!";
            }
        }
        JOptionPane.showMessageDialog(f, msg);

    }
    public static void setFormInputs(JTable emprunts,JTextField field1,JTextField field2){
        
        field1.setText(emprunts.getModel().getValueAt(emprunts.getSelectedRow(), 0).toString());
        field2.setText(emprunts.getModel().getValueAt(emprunts.getSelectedRow(), 1).toString());
           
    }
    public static void getEmprunts(JTable tab)
    {
           DAOEmprunt dao = new DAOEmprunt();
           DAOExemplaire daoE=new DAOExemplaire();
           Vector<Emprunt> emps    =( Vector<Emprunt>)dao.retreive();
           Vector < Vector<Emprunt> > matrice = new  Vector <>();
           
           Vector<String>  header = new  Vector<String>();
           header.add("CIN");
           header.add("ISBN");
           header.add("idExpmlaire");
           header.add("Date emprunt");
           
            for(Emprunt e :emps )
           {
                Vector v = new Vector();
                v.add(e.getId().getAd().getCin());
               
                v.add(daoE.getIsbn(e.getId().getExmp().getIdexp()));
                 v.add(e.getId().getExmp().getIdexp());
                v.add(e.getId().getDateemp());
                System.out.println(e.getId().getDateemp());
                matrice.add(v);
           
           }
        
           tab.setModel(new javax.swing.table.DefaultTableModel(matrice,header));
    }
}
