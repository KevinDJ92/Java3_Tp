package com.managedBean;

import com.entities.UserContact;
import com.entities.User;
import com.manager.ContactManager;
import com.manager.UserManager;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "afficherContactMB")
@SessionScoped
public class AfficherContactMB implements Serializable{
    private ArrayList<UserContact> mesDemande;
    private boolean isEmpty;
    private ArrayList<User> mesContact;
    private int id_user_test;
    
         @PostConstruct
    public void initData(){
        id_user_test = 1;
        isEmpty = true;
        mesDemande = (ArrayList<UserContact>) ContactManager.GetAllContactById(id_user_test);
        mesContact = getUserFromContact(mesDemande);
    }
    
    public ArrayList<User> getUserFromContact(ArrayList<UserContact> lContact){
                ArrayList<User> lUser = new ArrayList<>();
                for(UserContact user : lContact){
            if(user.getId_user() != 1){
                lUser.add(UserManager.selectUserById(user.getId_user()));
                
            }
            else{
                lUser.add(UserManager.selectUserById(user.getId_contact()));
            }
            }
                if(!lUser.isEmpty())
                    isEmpty = false;
                return lUser;
    }

    public ArrayList<UserContact> getMesDemande() {
        return mesDemande;
    }

    public void setMesDemande(ArrayList<UserContact> mesDemande) {
        this.mesDemande = mesDemande;
    }

    public boolean isIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public ArrayList<User> getMesContact() {
        return mesContact;
    }

    public void setMesContact(ArrayList<User> mesContact) {
        this.mesContact = mesContact;
    }
    
    public AfficherContactMB() {
    }
    
}
