/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedBean;

import com.entities.Preferences;
import com.entities.User;
import com.manager.UserManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author damon
 */
@Named(value = "afficherMatchMB")
@ViewScoped
public class afficherMatchMB implements Serializable{
        private ArrayList<User> users;
        private HashMap<String, Object> parms;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public HashMap<String, Object> getParms() {
        return parms;
    }

    public void setParms(HashMap<String, Object> parms) {
        this.parms = parms;
    }

    public LoginBean getLoginbean() {
        return loginbean;
    }

    public void setLoginbean(LoginBean loginbean) {
        this.loginbean = loginbean;
    }
        
        
@ManagedProperty(value="#{loginBean}")
    private LoginBean loginbean;

    public afficherMatchMB() {
    }
    
       @PostConstruct
   public void init() {
            
            parms = getPreferenceFromUser(loginbean.getUser());
            users = (ArrayList<User>) UserManager.getPreferredUser(parms);
            
    }
   
   public HashMap<String, Object> getPreferenceFromUser(User userid){
        User user = UserManager.getUserPreferences(userid);
        Preferences preference = user.getPreferences();    
        String sex_preference = null;
         
        HashMap<String, Object> parms = new HashMap<String, Object>();    
            parms.put("id_user", user.getId_user());
            parms.put("sex", user.getSex());
            parms.put("date_of_bith", user.getDate_of_birth());
            parms.put("height", user.getHeight());
            parms.put("min_age", preference.getMin_age());
            parms.put("max_age", preference.getMax_age());  
            parms.put("min_height", preference.getMin_height());
            parms.put("max_height", preference.getMax_height());  

            if (sex_preference != null)
                parms.put("sex_preference", preference.getSex_preference());
        return parms;
   }
}
