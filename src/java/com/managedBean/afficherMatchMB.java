package com.managedBean;

import com.entities.Preferences;
import com.entities.User;
import com.manager.UserManager;
import com.utils.DateFunctions;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.joda.time.LocalDate;

@ManagedBean
@SessionScoped
public class afficherMatchMB implements Serializable{
    private ArrayList<User> users;
    private HashMap<String, Object> parms;

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

    public HashMap<String, Object> getParms() {
        return parms;
    }

    public void setParms(HashMap<String, Object> parms) {
        this.parms = parms;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
    
    @PostConstruct
    public void init() {  
         System.out.println("Show the user first name:  " + loginBean.getUser().getId_user());
         Integer id_user = loginBean.getUser().getId_user();
         
        parms =  getPreferenceFromUser(id_user);
        
        users = (ArrayList<User>) UserManager.getPreferredUser(parms);  
    }
   
   public HashMap<String, Object> getPreferenceFromUser(Integer id_user){
        User user = UserManager.getUserPreferences(id_user);
        
        Preferences preference = user.getPreferences();  
        String sex_preference = null;
        
        LocalDate lb_birthday = DateFunctions.dateToLocalDate(user.getDate_of_birth());
        System.out.println("Local BirthDay:  " + lb_birthday);
        
        int age = DateFunctions.calculateAgeWithBirthDayPeriod(lb_birthday);
        
        System.out.println("!!!! Age: " + age);
        
        HashMap<String, Object> parms = new HashMap<String, Object>();    
            parms.put("id_user", user.getId_user());
            parms.put("sex", user.getSex());
            parms.put("age", age);
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
