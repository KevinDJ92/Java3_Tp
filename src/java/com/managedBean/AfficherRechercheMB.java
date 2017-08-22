/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedBean;

import com.entities.Preferences;
import com.entities.User;
import com.manager.UserManager;
import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author damon
 */
@ManagedBean
@Named(value = "afficherRechercheMB")
@RequestScoped
public class AfficherRechercheMB {
    private Preferences pref;
    private User user;
    private  HashMap<String, Object> parms ;
    private ArrayList<User> lUser;
    @PostConstruct
    public void initData(){
        user = new User();
        pref = new Preferences();
        lUser =(ArrayList<User>) UserManager.selectAllUser();
        parms = new HashMap<String, Object>(); 

    }

    public Preferences getPref() {
        return pref;
    }

    public void setPref(Preferences pref) {
        this.pref = pref;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HashMap<String, Object> getParms() {
        return parms;
    }

    public void setParms(HashMap<String, Object> parms) {
        this.parms = parms;
    }

    public ArrayList<User> getlUser() {
        return lUser;
    }

    public void setlUser(ArrayList<User> lUser) {
        this.lUser = lUser;
    }
    public void searchContact(){

            HashMap<String, Object> parms = new HashMap<String, Object>();    
            parms.put("id_user", user.getId_user());
            parms.put("firstname",user.getFirst_name());
            parms.put("lastname",user.getLast_name());
            parms.put("email",user.getEmail());
            parms.put("sex", user.getSex());
            parms.put("age", user.getDate_of_birth());
            parms.put("min_age", pref.getMin_age());
            parms.put("max_age", pref.getMax_age());  
            parms.put("min_height", pref.getMin_height());
            parms.put("max_height", pref.getMax_height());     
            
        lUser = (ArrayList<User>)UserManager.getDynamicUser(parms);
    }
    
    
    /**
     * Creates a new instance of AfficherRechercheMB
     */
    public AfficherRechercheMB() {
    }
    
}
