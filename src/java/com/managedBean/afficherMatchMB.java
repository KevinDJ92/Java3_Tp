package com.managedBean;

import com.entities.Preferences;
import com.entities.User;
import com.manager.UserManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class afficherMatchMB implements Serializable{
    private ArrayList<User> users;
//    private HashMap<String, Object> parms;

    @ManagedProperty( value="#{loginBean}" )
    private LoginBean loginBean;     
    
    public afficherMatchMB() {
    }
    
    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

//    public HashMap<String, Object> getParms() {
//        return parms;
//    }
//
//    public void setParms(HashMap<String, Object> parms) {
//        this.parms = parms;
//    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
    
    @PostConstruct
    public void init() {  
         System.out.println("Show the user first name:  " + loginBean.getUser().getFirst_name());
         User user = new User();
//        user = loginBean.getUser();
         
//         getPreferenceFromUser(user);
//         users = (ArrayList<User>) UserManager.getPreferredUser(parms);  
    }
   
   public HashMap<String, Object> getPreferenceFromUser(User userid){
        System.out.println("Entered the has map"); 
       
        User user = UserManager.getUserPreferences(userid);
        System.out.println("User: "  + user); 
        
        Preferences preference = user.getPreferences();  
        System.out.println("Preference: "  + preference); 
        
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
